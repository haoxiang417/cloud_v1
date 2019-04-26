package com.lec.common.user.service;

/**
 * <p>业务数据的数据权限过滤器</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public interface CustomerAuthorityFilter extends AuthorityFilterContext{


    //客户模块的权限
    public String CUSTOMER_BASE_AUTHORITY_SQL= "customer_code IN(SELECT a.customer_code FROM crm_customer_user a WHERE a.userid={0})";


    /***
	 * 判断是否是某个业务模块
	 * @param menuid
	 * @return
	 */
	public boolean isCustomerModule(String menuid);
	
	/***
	 * 该模块的业务扩展功能是否已开启
	 * @param menuid
	 * @return
	 */
	public boolean isEnable(String menuid);
	
}
