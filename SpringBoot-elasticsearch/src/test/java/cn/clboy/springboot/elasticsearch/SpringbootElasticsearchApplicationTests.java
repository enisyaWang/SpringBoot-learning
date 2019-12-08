package cn.clboy.springboot.elasticsearch;

import cn.clboy.springboot.elasticsearch.pojo.Item;
import cn.clboy.springboot.elasticsearch.repository.ItemRepository;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.node.NodeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringbootElasticsearchApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ItemRepository itemRepository;

    /**
     * 测试创建索引
     *
     * @throws Exception
     */
    @Test
    public void testCreateIndex() throws Exception {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchRestTemplate.createIndex(Item.class);

        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchRestTemplate.putMapping(Item.class);
    }

    /**
     * 测试删除索引
     *
     * @throws Exception
     */
    @Test
    public void testDeleteIndex() throws Exception {
        elasticsearchRestTemplate.deleteIndex(Item.class);
    }

    /**
     * 测试新增文档
     *
     * @throws Exception
     */
    @Test
    public void testAddDocument() throws Exception {
        Item item = new Item(1L, "小米手机7", "手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        itemRepository.save(item);
    }

    /**
     * 测试批量新增文档
     *
     * @throws Exception
     */
    @Test
    public void testAddDocumentList() throws Exception {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    /**
     * 测试修改文档
     *
     * @throws Exception
     */
    @Test
    public void testUpdateDocument() throws Exception {
        //将title：小米手机改为 黑米手机666
        Item item = new Item(1L, "黑米手机666", "手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        itemRepository.save(item);
    }

    /**
     * 测试查询所有
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        Iterable<Item> items = itemRepository.findAll();
        items.forEach(System.out::println);
    }

    /**
     * 测试根据查询
     *
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception {
        Optional<Item> optional = itemRepository.findById(1l);
        System.out.println(optional.get());
    }

    /**
     * 测试查询全部，并按照价格降序排序
     *
     * @throws Exception
     */
    @Test
    public void testFindAllAndOrderByPrice() throws Exception {
        Iterable<Item> items = itemRepository.findAll(Sort.by("price").descending());
        items.forEach(System.out::println);

    }

    /**
     * 测试自定义方法，根据价格区间查询
     *
     * @throws Exception
     */
    @Test
    public void testQueryByPriceBetween() throws Exception {
        List<Item> items = itemRepository.findByPriceBetween(2000, 4000);
        items.forEach(System.out::println);
    }
}
