package com.lec.common.system.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.framework.base.BaseCtl;
/***
 * 登陆页面
 * @author yantao
 * @2013-04-04
 */
@Controller
public class LoginCtl extends BaseCtl{
    private final static Logger logger = LoggerFactory.getLogger(LoginCtl.class);	
	
	/***
	 * 登陆页面显示 以及错误提示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String left(String error,ModelMap model){
		if("true".equals(error)){
            logger.info("用户登陆失败！");
        }
		return "home/login";
	}


    @RequestMapping(value = "sameuser/")
    public String sameuser(){
        return "/error/sameuser";
    }

    @RequestMapping(value = "/timeout/")
    public String sessionTimtout(){
        return "/error/timeout";
    }
    

}
