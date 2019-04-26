/**
 * 
 */
package com.lec.common.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.lec.common.system.dao.UserDeskMapper;
import com.lec.common.system.service.ResourceService;
import com.lec.common.system.service.UserDeskService;
import com.lec.common.system.vo.UserDesk;
import com.lec.common.system.vo.UserDeskSearch;
import com.lec.common.user.service.MenuCacheService;
import com.lec.common.user.service.UserService;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.cache.Cache;

/**
 * 用户自定义桌面接口实现
 * @author kouyunhao
 * @version 1.0
 * 2013-6-28
 */
@Service("userDeskService")
public class UserDeskServiceImpl extends AbstractBaseService<UserDesk,UserDeskSearch> implements UserDeskService {

	@Resource
	UserDeskMapper userDeskMapper;
	
	@Resource
	UserService userService;
	
	@Resource
	ResourceService resourceService;
	
	@Resource
	MenuCacheService MenuCacheService;
	
	@Resource
	Cache cache;

	/* (non-Javadoc)
	 * @see@see com.lec.core.service.AbstractBaseService#getBaseMapper()
	 */
	@Override
	protected BaseMapper<UserDesk, UserDeskSearch> getBaseMapper() {
		return userDeskMapper;
	}

	/* (non-Javadoc)
	 * @see@see com.lec.common.system.service.UserDeskService#findAll()
	 */
	@Override
	public List<UserDesk> findAll() {
		UserDeskSearch search = new UserDeskSearch();
		search.setOrderByClause("SCREENNUM");
		List<UserDesk> userDeskList = super.selectByExample(search);
//		if(userDeskList != null && userDeskList.size() != 0){
//			refreshCache();
//		}
		return userDeskList;
	}

	/* (non-Javadoc)
	 * @see@see com.lec.common.system.service.UserDeskService#hasResourceByRoleId(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean hasResourceByRoleId(String roleid, String resid) {
		return resourceService.hasResourceByRoleId(roleid, resid);
	}

	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#deleteById(java.lang.String)
	 */
	@Override
	@Transactional
	public int deleteById(String id) {
		int result =  super.deleteById(id);
//		if(result > 0){
//		    refreshCache();
//		}
	    return result;
	}
	
	@Transactional
	public int deleteByExample(UserDeskSearch example) {
		int result = super.deleteByExample(example);
//		if(result > 0){
//		    refreshCache();
//		}
	    return result;
	}
	
	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public int save(UserDesk record) {
		int result = super.save(record);
//		if(result > 0){
//			refreshCache();
//		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.lec.common.deptment.service.deskService#refreshCache()
	 */
	@Override
	public void refreshCache() {
		List<UserDesk> caches =  findAll();
		if(caches != null && caches.size() != 0){
			Table<String, String, String> table = HashBasedTable.create();
			for (UserDesk desk : caches) {
				//存储的对象为table
				table.put(desk.getId(), UserDesk.class.getSimpleName(),desk.getScreennum());
			}
			cache.put(UserDesk.class.getSimpleName(), table);
		}
	}

	/* (non-Javadoc)
	 * @see@see com.lec.common.system.service.UserDeskService#getListByUserIdAndScreennum()
	 */
	@Override
	public List<UserDesk> findListByUserIdAndScreennum(String userId, String screennum) {
		UserDeskSearch search = new UserDeskSearch();
		search.createCriteria().andUserIdEqualTo(userId).andScreennumEqualTo(screennum);
		return userDeskMapper.selectByExample(search);
	}

	/* (non-Javadoc)
	 * @see@see com.lec.common.system.service.UserDeskService#findListByUserId(java.lang.String)
	 */
	@Override
	public List<UserDesk> findListByUserId(String userId) {
		UserDeskSearch search = new UserDeskSearch();
		search.createCriteria().andUserIdEqualTo(userId);
		search.setOrderByClause("SCREENNUM");
		return userDeskMapper.selectByExample(search);
	}
	
}
