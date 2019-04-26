  /* 
   * Copyright 2012  diablo stutio TECHNOLOGY CO., TLD.
   *
   */
package com.lec.core.web;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.core.security.OperatorDetails;
import com.lec.framework.security.SpringSecurityUtils;

/**
 * <h2>基础控制器</h2>
 * @author zhouhaijian
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ForwardCtl {
	/***
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value="/forward/{url}/{module}/{page}/",method = RequestMethod.GET)
	public ModelAndView forward(@PathVariable String url,@PathVariable String module,@PathVariable String page,HttpServletRequest req){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		ModelAndView mv =  new ModelAndView(url+"/"+module+"/"+page);
		this.setView(mv, req);
		this.setParams(mv, req);
		return mv;
	}
	
	//设置参数
	private void setView(ModelAndView mv, HttpServletRequest req) {
		Enumeration<String> e = req.getParameterNames();
		if (e == null) {
			return;
		}
		String key = null;
		while (e.hasMoreElements()) {
			key = e.nextElement();
			mv.addObject(key, req.getParameter(key));
		}
	}
	
	@RequestMapping(value="/forward/{url}/{page}/",method = RequestMethod.GET)
	public ModelAndView forward(@PathVariable String url,@PathVariable String page,HttpServletRequest req){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		ModelAndView mv =  new ModelAndView(url+"/"+page);
		this.setView(mv, req);
		this.setParams(mv, req);
		return mv;
	}
	
	/**
	 * 将地址传值放入ModelAndView
	 * @param mv
	 * @param req
	 */
	private void setParams(ModelAndView mv, HttpServletRequest req) {
		if (req == null) {
			return;
		}
		Map<String, String[]> map = req.getParameterMap();
		if (map == null) {
			return;
		}
		for (String key : map.keySet()) {
			mv.addObject(key, this.getStrByArray(map.get(key)));
		}
	}
	
	/**
	 * 拼接属性值
	 * @param strs
	 * @return
	 */
	private String getStrByArray(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		for (String s : strs) {
			str.append(s);
			str.append(",");
		}
		if (str.length() > 0) {
			return str.substring(0, str.length()-1);
		}
		return "";
	}
	
	@RequestMapping(value="/forward/{url}/{module}/{page1}/{page2}/",method = RequestMethod.GET)
	public ModelAndView forward(@PathVariable String url,@PathVariable String module,@PathVariable String page1,@PathVariable String page2,HttpServletRequest req){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		ModelAndView mv =  new ModelAndView(url+"/"+module+"/"+page1+"/"+page2);
		this.setView(mv, req);
		this.setParams(mv, req);
		return mv;
	}
	
	/***
	 * 跳转到登陆页面
	 * @param url
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/forwardLogin/",method = RequestMethod.GET)
	public String forwardLogin(String url, String page, HttpServletRequest req, HttpServletResponse res){
		return "redirect:/login";
	}


    @RequestMapping(value="/forward/page/",method = RequestMethod.GET)
    public String forwardPage(String farurl,HttpServletRequest req){
        return "redirect:/"+farurl;//+"?r="+UUID.randomUUID();
    }
}
