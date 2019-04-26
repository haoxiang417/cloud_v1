package com.lec.core.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lec.common.system.service.ParamsService;
import com.lec.framework.constant.Constant;
import com.lec.framework.log.Logging;


/**
 * 系统启动监听器
 */
public class SystemInitListener implements ServletContextListener {
	private static final Logging logger = new Logging(SystemInitListener.class);
	
    public void contextDestroyed(ServletContextEvent sce) {

    }

	public void contextInitialized(ServletContextEvent sce) {
    	//获取产品发布模式
    	String runMode = sce.getServletContext().getInitParameter("run.mode");
    	String jmsURL = sce.getServletContext().getInitParameter("org.apache.activemq.brokerURL");

    	if(Constant.RELEASE_MODE.equals(runMode)){
    		logger.debugLine();
    	    logger.info("********************************************");
    	    logger.info("系统检测到本系统运行模式为：发布模式");
    		sce.getServletContext().setAttribute(Constant.APPLICATION_CONTEXT_MODE,runMode);
    	}else{
    		logger.warn("系统检测到本系统运行模式为：开发调试模式");
    	}
    	if(StringUtils.isNotBlank(jmsURL)){
    		logger.info("消息服务器的地址为:"+jmsURL);
    		System.setProperty("atds.org.apache.activemq.brokerURL",jmsURL);
    	}
        systemStartup(sce.getServletContext());

    }

    /**
     * 应用平台启动 
     */
	private void systemStartup(ServletContext servletContext) {
        // 用户对应用初始化的一些处理，需要可以加。
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        
        logger.debugLine();
        logger.info("********************************************");
        logger.info("系统正在启动...");
        logger.info("正在加载系统参数...");
        ParamsService paramServcie = applicationContext.getBean(ParamsService.class);
        Map<String,String> maps = paramServcie.getAllParams("1");
        ParamsService.SYSTEM_PARAMS.putAll(maps);
        
        //存入用户参数
        Map<String,String> userMaps = paramServcie.getAllParams("0");
        ParamsService.SYSTEM_PARAMS.putAll(userMaps);

        maps.putAll(userMaps);        
        //存入application变量，便于页面使用
        servletContext.setAttribute("atms",maps);
        
        //设置web应用路径
        servletContext.setAttribute("contextPath", servletContext.getContextPath());
        String path = servletContext.getRealPath("/");
        String webroot = System.getProperty("epms.root");
        if(StringUtils.isBlank(webroot)){
        	System.setProperty("epms.root",path);
        }
        
        logger.info("系统参数加载成功...");
        logger.info("********************************************");
        logger.info("系统启动成功.....");
        logger.debugLine();
    }
	
}
