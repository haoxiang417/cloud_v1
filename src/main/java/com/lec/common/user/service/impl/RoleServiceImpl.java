/**
 * 
 */
package com.lec.common.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.lec.common.system.dao.SystemResourceMapper;
import com.lec.common.user.cache.RoleCache;
import com.lec.common.user.dao.RoleMapper;
import com.lec.common.user.service.RoleService;
import com.lec.common.user.vo.Role;
import com.lec.common.user.vo.RoleSearch;
import com.lec.common.user.vo.RoleSearch.Criteria;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.base.Page;
import com.lec.framework.cache.Cache;
import com.lec.framework.util.StringUtils;

/**
 * 角色接口实现
 * @author zhouhaij
 */
@Service("roleService")
public class RoleServiceImpl extends AbstractBaseService<Role,RoleSearch> implements RoleService {

	@Resource
	RoleMapper roleMapper;
	@Resource
	Cache cache;
	
	@Resource
	SystemResourceMapper systemResourceMapper;
	
	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#getBaseMapper()
	 */
	@Override
	protected BaseMapper<Role,RoleSearch> getBaseMapper() {
		return roleMapper;
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.RoleService#findAll()
	 */
	@Override
	public List<Role> findAll() {
		return roleMapper.getRoleResourceContent(null);
	}

	@Override
	public List<Role> getRoleResourceContent(Role role) {
		return roleMapper.getRoleResourceContent(role);
	}

	@Override
	public Page getRolesByCondition(Map<String, Object> map, int pageNo,int pageSize, String sortType) {
		RoleSearch search = new RoleSearch();
		Criteria criteria = search.createCriteria();
		if(map!=null){
			
			if(StringUtils.notEmpty(map.get("name")+"")){
				criteria.andNameEqualTo(map.get("name").toString());
			}
		}
		if(StringUtils.notEmpty(sortType)){
			search.setOrderByClause(sortType);
		}
		Page page = selectByExample(search, pageNo, pageSize);
		return page;
	}

	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#deleteById(java.lang.String)
	 */
	@Override
	@Transactional
	public int deleteById(String id) {
		systemResourceMapper.deleteResourceByRoleId(id);
		int isOK = super.deleteById(id);
		this.refreshCache();
		return isOK;
	}

	@Override
	public int save(Role record) {
		int isOK = super.save(record);
		this.refreshCache();
		return isOK;
	}

	@Override
	public int updateByIdSelective(Role record) {
		int isOK = super.updateByIdSelective(record);
		this.refreshCache();
		return isOK;
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.RoleService#containsName(java.lang.String)
	 */
	@Override
	public boolean containsName(String name) {
		return roleMapper.getRolesByName(name)>0;
	}

	@Override
	public void refreshCache() {
		List<Role> roles = this.findAll();
		Table<String, String, String> table = HashBasedTable.create();
		Table<String, String, String> table2 = HashBasedTable.create();
		for (Role role : roles) {
			//存储的对象为table
			table.put(role.getId(), RoleCache.ID_NAME, role.getName());
			table2.put(role.getCode(), RoleCache.CODE_NAME, role.getName());
		}
		cache.put(RoleCache.ID_NAME, table);
		cache.put(RoleCache.CODE_NAME, table2);
	}
	
}
