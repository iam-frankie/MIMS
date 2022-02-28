package com.frankie.programmer.service.admin;

import java.util.*;


import org.springframework.stereotype.Service;

import com.frankie.programmer.entity.admin.Menu;

/*
 * 菜单管理service层
 */
@Service
public interface MenuService {

	public int add(Menu menu);
	public List<Menu> findList(Map<String, Object> queryMap);
	public List<Menu> findTopList();
	public int getTotal(Map<String, Object> queryMap);
	public int edit(Menu menu);
	public int delete(Long id);
	public List<Menu> findChildernList(Long parentId);
	public List<Menu> findListByIds(String ids);
}
