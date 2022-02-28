package com.frankie.programmer.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.frankie.programmer.entity.admin.OrderIn;

/**
 * 进货单service接口
 *
 */
@Service
public interface OrderInService {
	public int add(OrderIn orderIn);
	public int edit(OrderIn orderIn);
	public List<OrderIn> findList(Map<String, Object> queryMap);
	public Integer getTotal(Map<String, Object> queryMap);
	public int delete(Long id);
}
