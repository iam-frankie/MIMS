package com.frankie.programmer.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.frankie.programmer.entity.admin.Stock;

/**
 * 商品库存dao
 *
 */
@Repository
public interface StockDao {
	public int add(Stock stock);
	public int edit(Stock stock);
	public Stock findByProductId(Long id);
	public List<Stock> findList(Map<String, Object> queryMap);
	public Integer getTotal(Map<String, Object> queryMap);
	public int delete(Long id);
}
