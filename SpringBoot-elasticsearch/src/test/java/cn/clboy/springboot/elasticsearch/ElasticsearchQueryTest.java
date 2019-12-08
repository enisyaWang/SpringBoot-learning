package cn.clboy.springboot.elasticsearch;

import cn.clboy.springboot.elasticsearch.pojo.Item;
import cn.clboy.springboot.elasticsearch.repository.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.aggregations.metrics.avg.ParsedAvg;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/12/8 下午2:07
 * @Since 1.0.0
 */

@SpringBootTest
public class ElasticsearchQueryTest {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testBasicQuery() {
        // 词条查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "华为");
        // 执行查询
        Iterable<Item> items = itemRepository.search(queryBuilder);
        items.forEach(System.out::println);
    }

    /**
     * 测试自定义查询
     */
    @Test
    public void testNativeQuery() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "手机"));
        // 执行搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        items.forEach(System.out::println);
    }

    /**
     * 测试查询分页
     *
     * @throws Exception
     */
    @Test
    public void testNativeQueryByPage() throws Exception {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));

        //构建分页信息，page：页码(从0开始)，size：每页显示条目数
        int page = 0;
        int size = 2;

        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        //执行查询
        Page<Item> pageResult = this.itemRepository.search(queryBuilder.build());
        System.out.println("总页数：" + pageResult.getTotalPages());
        System.out.println("总条数：" + pageResult.getTotalElements());
        System.out.println("每页显示条数：" + pageResult.getSize());
        System.out.println("当前页码：" + pageResult.getNumber());

        pageResult.forEach(System.out::println);
    }

    /**
     * 测试查询排序
     *
     * @throws Exception
     */
    @Test
    public void testNativeQueryOrderByPrice() throws Exception {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));

        //添加排序条件，根据价格降序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));

        //执行查询
        Page<Item> pageResult = this.itemRepository.search(queryBuilder.build());

        pageResult.forEach(System.out::println);
    }

    /**
     * 测试聚合查询(ElasticsearchRestTemplate)
     *
     * @throws Exception
     */
    @Test
    public void testNativeQueryAggregation() throws Exception {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 不查询任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));

        //添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(AggregationBuilders.terms("brandAgg").field("brand"));

        //执行查询
        Page<Item> pageResult = this.itemRepository.search(queryBuilder.build());

        //把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggregatedPageResult = (AggregatedPage<Item>) pageResult;

        //从结果中取出名为brands的那个聚合，因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        ParsedStringTerms parsedStringTerms = (ParsedStringTerms) aggregatedPageResult.getAggregation("brandAgg");
        //获取桶
        List<ParsedStringTerms.ParsedBucket> buckets = (List<ParsedStringTerms.ParsedBucket>) parsedStringTerms.getBuckets();

        for (ParsedStringTerms.ParsedBucket bucket : buckets) {
            //获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            //获取桶中的文档数量
            System.out.println(bucket.getDocCount());
        }
    }

    /**
     * 测试聚合查询（ElasticsearchTemplate）
     * (需切换为ElasticsearchTemplate如果使用ElasticsearchRestTemplate会抛出类型转换异常)
     */
    @Test
    public void testAgg() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));

        //添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(AggregationBuilders.terms("brands").field("brand"));

        //查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemRepository.search(queryBuilder.build());
        // 解析
        // 从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("brands");
        //获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 遍历
        for (StringTerms.Bucket bucket : buckets) {
            //获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            //获取桶中的文档数量
            System.out.println(bucket.getDocCount());
        }

    }

    /**
     * 测试聚合中嵌套聚合(子聚合)
     * 查询每个平均价格
     * @throws Exception
     */
    @Test
    public void testSubAggregation() throws Exception {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 不查询任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));

        //添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("brandAgg").field("brand")
                .subAggregation(AggregationBuilders.avg("brandPriceAvg").field("price")));

        //执行查询
        Page<Item> pageResult = this.itemRepository.search(queryBuilder.build());

        //把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggregatedPageResult = (AggregatedPage<Item>) pageResult;

        //从结果中取出名为brands的那个聚合，因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        ParsedStringTerms parsedStringTerms = (ParsedStringTerms) aggregatedPageResult.getAggregation("brandAgg");
        //获取桶
        List<ParsedStringTerms.ParsedBucket> buckets = (List<ParsedStringTerms.ParsedBucket>) parsedStringTerms.getBuckets();

        for (ParsedStringTerms.ParsedBucket bucket : buckets) {
            //获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            //获取桶中的文档数量
            System.out.println(bucket.getDocCount());
            //获取子聚合
            Aggregations aggregations = bucket.getAggregations();
            //非rest是InternalAvg
            ParsedAvg avgAgg = aggregations.get("brandPriceAvg");
            double avg = avgAgg.getValue();
            System.out.println(avg);
        }
    }
}