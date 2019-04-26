package com.lec.core.security;

import com.lec.common.user.vo.User;
import com.lec.framework.security.SpringSecurityUtils;
import com.lec.core.security.UserThreadLocal;
import com.lec.framework.util.IpAddressUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * @author zhouhaijian
 * @version 1.0
 */
public class FilterSecurityInterceptor extends AbstractSecurityInterceptor   implements Filter {

    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    /**
     * Method that is actually called by the filter chain. Simply delegates to
     * the {@link #invoke(org.springframework.security.web.FilterInvocation)} method.
     * 
     * @param request
     *            the servlet request
     * @param response
     *            the servlet response
     * @param chain
     *            the filter chain
     * 
     * @throws java.io.IOException
     *             if the filter chain fails
     * @throws javax.servlet.ServletException
     *             if the filter chain fails
     */
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        
        OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
        if (userInfo != null) {
            // 记录当前线程用户信息,数据审计信息用
            User user = new User();
            user.setName(userInfo.getRealName());
            UserThreadLocal.set(user);
            // 设置用户IP地址
            if (StringUtils.isBlank(userInfo.getIpAddress())) {
                userInfo.setIpAddress(IpAddressUtil.getIpAddress((HttpServletRequest) request));
            }
        }
        invoke(fi);
    }

    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    public Class<? extends Object> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    public void invoke(FilterInvocation fi) throws IOException,
            ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    public void setSecurityMetadataSource(
            FilterInvocationSecurityMetadataSource newSource) {
        this.securityMetadataSource = newSource;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}