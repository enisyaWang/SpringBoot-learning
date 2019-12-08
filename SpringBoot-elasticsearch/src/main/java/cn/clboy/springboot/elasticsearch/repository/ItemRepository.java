package cn.clboy.springboot.elasticsearch.repository;

import cn.clboy.springboot.elasticsearch.pojo.Item;
import org.elasticsearch.repositories.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/12/8 下午1:28
 * @Since 1.0.0
 */

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

    /**
     * 根据价格区间查询
     *
     * @param price1
     * @param price2
     * @return
     */
    List<Item> findByPriceBetween(double price1, double price2);
}