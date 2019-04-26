package com.lec.common.user.service;

import java.util.Map;

/**
 * <p>用户数据权限过滤器</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public interface AuthorityFilterContext {
	
	/***
	 * 权限过滤时往map中添加的key
	 */
	String DEPARTMENT_KEY = "orgs";
	
	/***
	 * 根据menuid过滤对应的数据权限
	 * 方法是在map中添加对应的子查询语句
	 * @param map
	 * @param menuid
	 * @return
	 */
	public Map<String, Object> filter(Map<String, Object> map, String menuid);
	
	/**
	 * 根据menuid返回过滤数据权限对应的sql语句
	 * @author lhh
	 * @param menuid 
	 * @return
	 */
	public String filterSql(String menuid);

}
