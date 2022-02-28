package com.frankie.programmer.controller.admin;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.frankie.programmer.entity.admin.User;
import com.frankie.programmer.service.admin.UserService;
import com.frankie.programmer.util.CpachaUtil;

/*
 * 
 * Frankie Practice
 */

@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * 系统登录后的主页
	 */
	@RequestMapping(value= "/index",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		model.setViewName("system/index");
		return model;
	}
	
	/*
	 * 系统登录后的欢迎页
	 */
	@RequestMapping(value= "/welcome",method=RequestMethod.GET)
	public ModelAndView welcome(ModelAndView model) {
		model.setViewName("system/welcome");
		return model;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		model.setViewName("system/login");
		return model;
	}
	
	/*
	 * 登录页面
	 */

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String>loginAct(User user, String cpacha, HttpServletRequest request){
		HashMap<String, String> ret = new HashMap<String, String>();
		if(user == null) {
			ret.put("type","error");
			ret.put("msg","用户信息未填");
			return ret;
		}
		if(StringUtils.isEmpty(cpacha)) {
			ret.put("type","error");
			ret.put("msg","验证码未填");
			return ret;
		}
		if(StringUtils.isEmpty(user.getUsername())) {
			ret.put("type","error");
			ret.put("msg","用户名未填");
			return ret;
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			ret.put("type","error");
			ret.put("msg","密码未填");
			return ret;
		}
		Object loginCpacha = request.getSession().getAttribute("loginCpacha");
		if(loginCpacha == null) {
			ret.put("type","error");
			ret.put("msg","会话超时，需刷新界面");
			return ret;
		}
		if(!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())) {
			ret.put("type","error");
			ret.put("msg","验证码错误请重新输入");
			return ret;
		}
		
		User findByUsername = userService.findByUsername(user.getUsername());
		if(findByUsername == null) {
			ret.put("type","error");
			ret.put("msg","该用户名不存在");
		}
		if(!user.getPassword().equals(findByUsername.getPassword())) {
			ret.put("type","error");
			ret.put("msg","密码错误请重新输入");
		}
		
		request.getSession().setAttribute("admin", findByUsername); //将用户拿出来作为全局变量
		ret.put("type","success");
		ret.put("msg","已登录");
		return ret;
	}
	
	
	/*
	 * 系统验证码
	 * 
	 */
	@RequestMapping(value="/get_cpacha",method = RequestMethod.GET)
	public void generateCpacha(
			@RequestParam(name = "vl",required = false, defaultValue = "4") Integer vcodeLen,
			@RequestParam(name = "w",required = false,defaultValue = "100") Integer width,
			@RequestParam(name = "h",required = false,defaultValue = "30") Integer height,
			@RequestParam(name = "type",required = true,defaultValue = "loginCpacha") String cpachaType,
			HttpServletRequest request,
			HttpServletResponse response) {
	CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);
	String generatorVCode = cpachaUtil.generatorVCode();
	request.getSession().setAttribute(cpachaType, generatorVCode);
	//会话，第一次向服务器发起请求，建立一个会话，在服务器设定时间范围内一直存在，本质就是一个区别用户的全局变量
	BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
	try {
		//以图的形式写到输出流里，response为返回到用户的对象
		ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
