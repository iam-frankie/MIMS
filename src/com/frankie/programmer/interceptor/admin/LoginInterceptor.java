package com.frankie.programmer.interceptor.admin;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.sun.javafx.collections.MappingChange.Map;

import net.sf.json.JSONObject;

/*
 * 后台登录拦截器
 */


public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		Object admin = request.getSession().getAttribute("admin");
		if(admin == null) {
			System.out.println("链接"+requestURI+"进入拦截器！");
			//表示未登录或者登录失效
			String header = request.getHeader("X-Requested-With");
			//判断是否是ajax请求
			if("XMLHttpRequest".equals(header)) {
				//是ajax请求，做以下处理
				HashMap<String, String> ret = new HashMap <String, String>();
					ret.put("type", "error");
					ret.put("msg","登录会话超时/还未登录，请重新登录");
					response.getWriter().write(JSONObject.fromObject(ret).toString());
					return false;
			}
			//表示普通链接跳转，直接重定向到登录页面
			response.sendRedirect(request.getServletContext().getContextPath()+"/system/login");
			return false;
		}
		return true; //false不能进入，true可以进入
	}

}
