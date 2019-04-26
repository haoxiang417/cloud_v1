package com.lec.common.user.service;

/**
 * <p>业务数据的数据权限过滤器</p>
 * <p>与部门的过滤器的区别在于，数据中表里存在org字段,但是与基础库可能不在同一实例中，无法采用子查询的方式过滤</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public interface BlackAuthorityFilter extends AuthorityFilterContext{
	
	/***
	 * 判断是否是布控系统的业务模块
	 * @param menuid
	 * @return
	 */
	public boolean isBlackModule(String menuid);
	
	/***
	 * 该模块的业务扩展功能是否已开启
	 * @param menuid
	 * @return
	 */
	public boolean isEnable(String menuid);
	
}
