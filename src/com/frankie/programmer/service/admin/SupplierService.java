package com.frankie.programmer.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.frankie.programmer.entity.admin.Supplier;

/**
 * 供应商service接口
 * @author frankie
 *
 */
@Service
public interface SupplierService {
	public int add(Supplier supplier);
	public int edit(Supplier supplier);
	public List<Supplier> findList(Map<String, Object> queryMap);
	public Integer getTotal(Map<String, Object> queryMap);
	public int delete(Long id);
}
