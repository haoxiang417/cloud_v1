package com.lec.common.user.dao;

import java.util.List;

import com.lec.common.user.vo.User;
import com.lec.common.user.vo.UserSearch;
import com.lec.framework.base.BaseMapper;
/**
 * 用户服务dao
 * @author zhouhaij
 * @2013-3-26 下午04:38:54
 */
public interface UserMapper extends BaseMapper<User,UserSearch>{

	/***
	 * 根据用户id获取角色编码列表
	 * @param userid
	 * @return
	 */
	List<String> getRoleListByUser(String userid);
	
	/***
	 * 根据用户id获取角色编码列表
	 * @param userid
	 * @return
	 */
	List<String> getRoleNameListByUser(String userid);
}