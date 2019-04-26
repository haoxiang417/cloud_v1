package com.lec.common.user.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.lec.common.user.vo.User;
import com.lec.common.user.vo.UserSearch;
import com.lec.core.service.BaseService;
import com.lec.framework.base.Page;

/***
 * 用户接口
 * @author zhouhaij
 */
public interface UserService extends BaseService<User,UserSearch>{
	
	/***
	 * 获取用户的分页列表数据
	 * @param orgid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getUsersByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);
	
	/***
	 * 获取所有的用户
	 * @return
	 */
	public List<User> findAll(boolean disabled);
	

	/***
	 *  通过用户帐号查询该用户
	 * @param userName
	 * @return
	 */
	User findUserByLoginName(String userName);
	
	
	/***
	 * 通过用户Id获取其角色
	 * @param userId
	 * @return
	 */
	Set<GrantedAuthority> getRoleListByUser(String userId);
	
	/***
	 * 通过用户Id获取其角色名称集合
	 * @param userId
	 * @return
	 */
	List<String> getRoleNameListByUser(String userId);
	
	/***
	 * 删除用户
	 * @param ids
	 * @return
	 */
	public int deleteUser(String ids);
	
	/**
	 * 刷新缓存
	 * @author kouyunhao
	 * @version 1.0
	 * Jan 8, 2014
	 */
	void refreshCache();
	
}
