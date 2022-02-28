package com.frankie.programmer.service.admin.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frankie.programmer.dao.admin.ProductDao;
import com.frankie.programmer.entity.admin.Product;
import com.frankie.programmer.service.admin.ProductService;
/**
 * 商品service实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public int add(Product product) {
		// TODO Auto-generated method stub
		return productDao.add(product);
	}
	@Override
	public List<Product> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return productDao.findList(queryMap);
	}
	@Override
	public Integer getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return productDao.getTotal(queryMap);
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}
	@Override
	public int edit(Product product) {
		// TODO Auto-generated method stub
		return productDao.edit(product);
	}
	
}
