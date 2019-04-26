package com.lec.common.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.common.user.dao.UserRoleMapper;
import com.lec.common.user.service.MenuCacheService;
import com.lec.common.user.service.UserRoleService;
import com.lec.common.user.vo.User;
import com.lec.common.user.vo.UserRole;

/***
 * 用户角色管理接口实现
 * @author zhouhaij
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource
	UserRoleMapper userRoleMapper;

	@Resource
	MenuCacheService menuCacheService;
	
	/* (non-Javadoc)
	 * @see com.lec.common.user.service.UserRoleService#batchDeleteByRoles(java.util.List)
	 */
	@Override
	public int batchDeleteByRoles(String... values) {
		return userRoleMapper.batchDeleteByRoles(values);
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.UserRoleService#batchDeleteByUsers(java.util.List)
	 */
	@Override
	public int batchDeleteByUsers(String... values) {
		return userRoleMapper.batchDeleteByUsers(values);
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.UserRoleService#save(com.lec.common.user.vo.UserRole)
	 */
	@Override
	@Transactional
	public void save(UserRole... userRole) {
		if (userRole == null) {
			return;
		}
		batchDeleteByUsers(userRole[0].getUserId());
		for (UserRole ur : userRole) {
			String userId = ur.getUserId();
			userRoleMapper.save(ur);
			//刷新用户拥有的菜单缓存
			menuCacheService.cacheMenu(userId);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.UserRoleService#getUserByRoleId(java.lang.String)
	 */
	@Override
	public List<User> getUserByRoleId(String roleid) {
		return userRoleMapper.getUserByRoleId(roleid);
	}
	
	

}
