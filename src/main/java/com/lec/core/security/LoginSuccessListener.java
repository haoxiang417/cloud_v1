package com.lec.core.security;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.lec.common.log.service.SystemLogService;
import com.lec.common.log.vo.SystemLog;
import com.lec.common.user.vo.User;
import com.lec.framework.base.ApplicationContextHolder;
import com.lec.framework.log.Logging;
import com.lec.framework.util.DateUtil;
import com.lec.framework.util.UuidGenerateUtil;


/**
 * 用户登录成功事件监听器
 * 
 */
public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    /**
     * 日志
     */
    protected static Logging logger = new Logging(LoginSuccessListener.class);
    

    /**
     * 登录成功后事件处理
     */
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
    	logger.debugTitle("登录监听器启动......");
    	
    	CasAuthenticationToken authenticationToken = (CasAuthenticationToken) authenticationSuccessEvent.getSource();
        OperatorDetails userInfo = (OperatorDetails) authenticationToken.getPrincipal();
        WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) authenticationToken.getDetails();
        
        String ipAddress = authenticationDetails.getRemoteAddress();
        if (ipAddress.equals("127.0.0.1") || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
            // 根据网卡取本机配置的IP
            java.net.InetAddress inet = null;
            try {
                inet = java.net.InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                logger.error("IP地址获取失败.", e);
            }
            if(inet != null)
            ipAddress = inet.getHostAddress();
        }
        
        SystemLog log = new SystemLog();

        // 记录在线用户信息
        User user = new User();
        user.setName(userInfo.getUsername());
        UserThreadLocal.set(user);

        log.setId(UuidGenerateUtil.getUUIDLong());
        //记录日志
        log.setContent("成功登录系统");
        log.setIpAddress(ipAddress);
        log.setOperatorId(userInfo.getAccount());
        log.setOperatorName(userInfo.getRealName());
        log.setOperationTime(DateUtil.now());
        log.setType(1l);
        log.setLogLevel(1l);
        log.setCreateDate(DateUtil.now());
        log.setCreateBy(userInfo.getAccount());
        log.setStatus("0");
        
        SystemLogService  systemLogService = (SystemLogService)ApplicationContextHolder.getBean("systemLogServiceImpl");
        systemLogService.save(log);
        
        logger.debugLine();
        logger.debug("登录用户："+ user.getName());
        logger.debug("成功登录系统");
        logger.debugLine();
    }
}
