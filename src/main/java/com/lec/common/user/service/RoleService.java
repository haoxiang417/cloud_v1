package com.lec.common.user.service;

import java.util.List;
import java.util.Map;

import com.lec.common.user.vo.Role;
import com.lec.common.user.vo.RoleSearch;
import com.lec.core.service.BaseService;
import com.lec.framework.base.Page;
/***
 * 角色服务接口
 * @author zhouhaij
 */
public interface RoleService extends BaseService<Role,RoleSearch>{
	
	/***
	 * 获取所有的角色
	 * @return
	 */
	List<Role> findAll();

	/***
	 * 根据条件获取角色
	 * @param role
	 * @return
	 */
	List<Role> getRoleResourceContent(Role role);
	
	
	boolean containsName(String name);
	
	/***
	 * 获取用户的分页列表数据
	 * @param orgid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getRolesByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);
	
	/**
	 * 刷新缓存
	 */
	void refreshCache();
}
