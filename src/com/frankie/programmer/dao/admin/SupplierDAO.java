package com.frankie.programmer.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.frankie.programmer.entity.admin.Supplier;

/**
 * 供应商dao
 * @author frankie
 *
 */
@Repository
public interface SupplierDAO {
	public int add(Supplier supplier);
	public int edit(Supplier supplier);
	public List<Supplier> findList(Map<String, Object> queryMap);
	public Integer getTotal(Map<String, Object> queryMap);
	public int delete(Long id);
}
