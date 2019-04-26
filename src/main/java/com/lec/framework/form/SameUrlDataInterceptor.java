package com.lec.framework.form;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lec.framework.form.anotation.SameUrlData;

public class SameUrlDataInterceptor extends HandlerInterceptorAdapter {

	public static final String SESSION_MAP_TIME_KEY = "submitFormTime";
	
	public static final String SESSION_KEY = "submitFormData";
	
	/**
	 * 间隔时间，单位:秒
	 * 默认10秒
	 * 
	 * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
	 */
	private int intervalTime = 10;
	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod)handler;
			Method m = hm.getMethod();
			SameUrlData sud = m.getAnnotation(SameUrlData.class);
			if (sud != null) {
				if (this.validate(request)) {
					StringBuffer url = request.getRequestURL();
					response.sendRedirect(url.toString().replaceAll(sud.addPath()+"/", sud.listPath()+"/"));
					return false;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	@SuppressWarnings("unchecked")
	private boolean validate(HttpServletRequest request) {
		//本次参数集合
		Map<String, String[]> nowDataMap = new HashMap<String, String[]>();
		nowDataMap.putAll(request.getParameterMap());
		nowDataMap.put(SESSION_MAP_TIME_KEY, new String[]{System.currentTimeMillis()+""});
		
		//请求地址（作为存放session的key值）
		String url = request.getRequestURI();
		
		HttpSession session = request.getSession();
		Object sessionObj = session.getAttribute(SESSION_KEY);
		if (sessionObj != null) {
			Map<String, Object> sessionMap = (Map<String, Object>)sessionObj;
			if (sessionMap.containsKey(url)) {
				Map<String, String[]> saveMap = (Map<String, String[]>)sessionMap.get(url);
				if (this.compareMap(nowDataMap, saveMap) && this.compareTime(nowDataMap, saveMap)) {
					return true;
				}
			}
		}
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		sessionMap.put(url, nowDataMap);
		session.setAttribute(SESSION_KEY, sessionMap);
		return false;
	}
	
	/**
	 * 判断两个map是否相等
	 * @param map1
	 * @param map2
	 * @return
	 */
	private boolean compareMap(Map<String, String[]> map1, Map<String, String[]> map2) {
		boolean isEq = true;
		//map1的键值，map2存在否
		for (String key : map1.keySet()) {
			if (key.equals(SESSION_MAP_TIME_KEY)) {
				continue;
			}
			if (!map2.containsKey(key)) {
				isEq = false;
				break;
			}
			if (!this.compareArray(map1.get(key), map2.get(key))) {
				isEq = false;
				break;
			}
		}
		if (isEq) {
			//map2的键值，map1存在否
			for (String key : map2.keySet()) {
				if (key.equals(SESSION_MAP_TIME_KEY)) {
					continue;
				}
				if (!map1.containsKey(key)) {
					isEq = false;
					break;
				}
				if (!this.compareArray(map1.get(key), map2.get(key))) {
					isEq = false;
					break;
				}
			}
		}
		return isEq;
	}
	
	/**
	 * 判断两个数组是否一致
	 * @param strs1
	 * @param strs2
	 * @return
	 */
	private boolean compareArray(String[] strs1, String[] strs2) {
		Map<String, String> map = new HashMap<String, String>();
		boolean isEq = true;
		for (String s : strs1) {
			map.put(s, s);
		}
		for (String s : strs2) {
			if (!map.containsKey(s)) {
				isEq = false;
			}
		}
		return isEq;
	}
	
	/**
	 * 判断两次间隔时间
	 * @param nowMap
	 * @param sessionMap
	 * @return
	 */
	private boolean compareTime(Map<String, String[]> nowMap, Map<String, String[]> sessionMap) {
		long time1 = Long.valueOf(nowMap.get(SESSION_MAP_TIME_KEY)[0]);
		long time2 = Long.valueOf(sessionMap.get(SESSION_MAP_TIME_KEY)[0]);
		if ((time1 - time2) < (this.intervalTime * 1000)) {
			return true;
		}
		return false;
	}
	
}
