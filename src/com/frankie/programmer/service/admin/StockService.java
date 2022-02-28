package com.frankie.programmer.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.frankie.programmer.entity.admin.Stock;

/**
 * 库存service接口
 *
 */
@Service
public interface StockService {
	public int add(Stock stock);
	public int edit(Stock stock);
	public Stock findByProductId(Long id);
	public List<Stock> findList(Map<String, Object> queryMap);
	public Integer getTotal(Map<String, Object> queryMap);
	public int delete(Long id);
}
