/**
 * 
 */
package com.lec.common.user.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.lec.common.deptment.service.DepartmentService;
import com.lec.common.user.cache.UserCache;
import com.lec.common.user.dao.UserMapper;
import com.lec.common.user.service.UserRoleService;
import com.lec.common.user.service.UserService;
import com.lec.common.user.vo.User;
import com.lec.common.user.vo.UserRole;
import com.lec.common.user.vo.UserSearch;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.base.Page;
import com.lec.framework.cache.Cache;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.util.ListUtils;
import com.lec.framework.util.StringUtils;
import com.lec.framework.util.UuidGenerateUtil;

/**
 * 用户服务接口
 * 
 * @author zhouhaij
 */
@Service
public class UserServiceImpl extends AbstractBaseService<User, UserSearch> implements UserService {

	@Resource
	Cache cache;
	
	@Resource
	UserMapper userMapper;

	@Resource
	UserRoleService userRoleService;

	@Resource
	DepartmentService departmentService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lec.core.service.AbstractBaseService#getBaseMapper()
	 */
	@Override
	protected BaseMapper<User, UserSearch> getBaseMapper() {
		return userMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lec.common.user.service.UserService#findAll(boolean)
	 */
	@Override
	public List<User> findAll(boolean disabled) {
		UserSearch search = new UserSearch();
		search.createCriteria().andDisabledEqualTo(disabled);
		return userMapper.selectByExample(search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lec.common.user.service.UserService#findUserByLoginName
	 * (java.lang.String)
	 */
	@Override
	public User findUserByLoginName(String userName) {
		UserSearch search = new UserSearch();
		search.createCriteria().andAccountEqualTo(userName);
		List<User> user = userMapper.selectByExample(search);
		if (user == null || user.isEmpty())
			return null;
		return user.get(0);
	}

	@Transactional
	@Override
	public int deleteUser(String ids) {
		try {
			String[] id = ids.split(",");
			userRoleService.batchDeleteByUsers(id);
			for (String string : id) {
				deleteById(string);
			}
			if(id.length > 0){
				refreshCache();
			}
			return id.length;
		} catch (Exception e) {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lec.common.user.service.UserService#getRoleListByUser(java
	 * .lang.String)
	 */
	@Override
	public Set<GrantedAuthority> getRoleListByUser(String userId) {
		List<String> roles = userMapper.getRoleListByUser(userId);
		Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
		for (String role : roles) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role);
			set.add(authority);
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lec.common.user.service.UserService#getRoleNameListByUser
	 * (java.lang.String)
	 */
	@Override
	public List<String> getRoleNameListByUser(String userId) {
		return userMapper.getRoleNameListByUser(userId);
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public Page getUsersByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType) {
//        OperatorDetails userInfo =  SpringSecurityUtils.getCurrentUser();
//        String userid = "'"+userInfo.getId()+"'";
//        map.put(AuthorityFilterContext.DEPARTMENT_KEY,MessageFormat.format(UserAuthoritySQL.DEPT_SQL,new Object[]{userid,userid,userid,userid}));
        Page page = getListByCondition(map, pageNo, pageSize, sortType);
        if (page.getResult() != null) {
            for (Object user : page.getResult()) {
                User u = (User) user;
                List<String> roles = getRoleNameListByUser(u.getId());
                u.setRoleIds(userMapper.getRoleListByUser(u.getId()));
                u.setRoles(ListUtils.toString(roles, ","));
            }
        }
        return page;
	}

	@Override
	@Transactional
	@LogAspect
	public int save(User record) {
		String userid = UuidGenerateUtil.getUUIDLong();
		if (StringUtils.notEmpty(record.getId())) {
			userid = record.getId();
		}
		int records = userMapper.insertSelective(record);
		UserRole userRole = null;
		if (record.getRoleIds() != null && !record.getRoleIds().isEmpty()) {
			List<String> roles = record.getRoleIds();
			for (String string : roles) {
				userRole = new UserRole(userid, string);
				userRoleService.save(userRole);
			}
		}
		//add by kouyunhao 2014-01-08 刷新缓存。
		if(records > 0){
			refreshCache();
		}
		return records;
	}

	/* (non-Javadoc)
	 * @see@see com.lec.common.user.service.UserService#refreshCache()
	 */
	@Override
	public void refreshCache() {
		List<User> users = this.findAll(false);
		cache.put(User.class.getSimpleName(), users);
		
		Table<String, String, String> table = HashBasedTable.create();
		for (User user : users) {
			//存储的对象为table
			table.put(user.getId(), UserCache.USERNAME_CACHE, user.getName());
		}
		cache.put(UserCache.USERNAME_CACHE, table);
	}

	/* (non-Javadoc)
	 * @see@see com.lec.core.service.AbstractBaseService#updateByIdSelective(java.lang.Object)
	 */
	@Override
	public int updateByIdSelective(User record) {
		int result = super.updateByIdSelective(record);
		if(result > 0){
			refreshCache();
		}
		return result;
	}

}
