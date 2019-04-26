/**
 * 
 */
package com.lec.common.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lec.common.system.dao.SystemResourceMapper;
import com.lec.common.system.service.ResourceService;
import com.lec.common.system.service.SystemUserResourceService;
import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceSearch;
import com.lec.common.user.service.MenuCacheService;
import com.lec.common.user.type.MenuType;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.security.SpringSecurityUtils;
import com.lec.framework.util.UuidGenerateUtil;

/**
 * 资源服务接口实现
 * @author zhouhaij
 *
 */
@Service("resourceService")
public class ResourceServiceImpl extends AbstractBaseService<SystemResource,SystemResourceSearch> implements ResourceService {

	@Resource
	SystemResourceMapper systemResourceMapper;
	
	@Resource
	MenuCacheService menuCacheService;
	@Resource
	SystemUserResourceService systemUserResourceService;
	
	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ResourceService#grantRoleResource(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public void grantRoleResource(String roleid, String... resid) {
		systemResourceMapper.deleteResourceByRoleId(roleid);
		for (String string : resid) {
			this.addRoleResource(roleid, string);
		}
		menuCacheService.refreshCache(roleid);
	}

	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ResourceService#getChildren(java.lang.String)
	 */
	@Override
	public List<SystemResource> getChildren(String menuid,MenuType type) {
		SystemResourceSearch search = new SystemResourceSearch();
		search.createCriteria().andParentidEqualTo(menuid).andDisabledEqualTo(false).andTypeEqualTo(type.toString());
		return systemResourceMapper.selectByExample(search);
	}

	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ResourceService#hasChild(java.lang.String)
	 */
	@Override
	public boolean hasChild(String menuid,MenuType type) {
		SystemResourceSearch search = new SystemResourceSearch();
		search.createCriteria().andParentidEqualTo(menuid).andDisabledEqualTo(false).andTypeEqualTo(type.toString());
		int result = systemResourceMapper.countByExample(search);
		return result>0;
	}

	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#getBaseMapper()
	 */
	protected BaseMapper<SystemResource,SystemResourceSearch> getBaseMapper() {
		return systemResourceMapper;
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#findAll(boolean disabled)
	 */
	@Override
	public List<SystemResource> findAll(boolean disabled) {
		SystemResourceSearch search = new SystemResourceSearch();
		search.setOrderByClause("SORT_ORDER asc");
		search.createCriteria().andCodeIsNotNull().andDisabledEqualTo(disabled);
		return systemResourceMapper.selectByExample(search);
	}
	

	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ResourceService#findAllMenuByKeyWord(String)
	 */
	@Override
	public List<SystemResource> findAllMenuByKeyWord(String keyWord,String exinclude){
		SystemResourceSearch search = new SystemResourceSearch();
		search.setOrderByClause("SORT_ORDER asc");
		search.createCriteria()
		.andCodeIsNotNull()
		.andDisabledEqualTo(false)
		.andNameLike("%"+keyWord+"%")
		.andNameNotIn(Arrays.asList(exinclude.split(",")))
		.andTypeEqualTo(MenuType.MODULE.toString());
		List<SystemResource> res = systemResourceMapper.selectByExample(search);
		//添加节点的孩子节点
		List<SystemResource> resultList = new ArrayList<SystemResource>();
		for (SystemResource systemResource : res) {
			getChildResource(res,resultList,systemResource);
		}
		
		String[] exincludeMenus = exinclude.split(",");
		
		for (Iterator<SystemResource> iterator = resultList.iterator(); iterator.hasNext();) {
			SystemResource systemResource = iterator.next();
			for (int i = 0; i < exincludeMenus.length; i++) {
				if(systemResource.getName().equals(exincludeMenus[i])){
					iterator.remove();
				}
			}
		}
		
		res.addAll(resultList);
		return res;
	}

	/***
	 * 递归查找子节点
	 * @param res
	 * @param resultList
	 * @param systemResource
	 */
	private void getChildResource(List<SystemResource> res,List<SystemResource> resultList,SystemResource systemResource){
		String id = systemResource.getId();
		List<SystemResource> children = getChildren(id,MenuType.MODULE);
		for (SystemResource resource : children) {
			if(!res.contains(resource) && !resultList.contains(resource)){
				if(resource.getType().equals(MenuType.MODULE.toString())){
					resultList.add(resource);
				}
			}
			getChildResource(res,resultList,resource);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#getDeskTopMenuByuserId(java.lang.String)
	 */
	@Override
	public List<SystemResource> getDeskTopMenuByuserId(String userId) {
		return systemResourceMapper.getDeskTopMenuByuserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#getLeafMenusByUserId(java.lang.String)
	 */
	@Override
	public List<SystemResource> getLeafMenusByUserId(String userId) {
		return systemResourceMapper.getLeafMenusByUserId(userId);
	}

    public List<SystemResource> getAllResourceByUserId(String userId){
        return systemResourceMapper.getAllResourceByUserId(userId);
    }

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#getMenuButtonsByParentId(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getMenuButtonsByParentId(String userId, String menuId) {
		return systemResourceMapper.getMenuButtonsByParentId(userId, menuId);
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#getMenuButtonsByUserId(java.lang.String)
	 */
	@Override
	public List<SystemResource> getMenuButtonsByUserId(String userId) {
		return systemResourceMapper.getMenusByUserId(userId,MenuType.BUTTON.toString());
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#getMenusByUserId(java.lang.String, com.lec.common.user.type.MenuType)
	 */
	@Override
	public List<SystemResource> getMenusByUserId(String userId,MenuType menuType) {
		return systemResourceMapper.getMenusByUserId(userId,menuType.toString());
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ResourceService#getMenusByUserId(java.lang.String, java.lang.String, com.lec.common.user.type.MenuType)
	 */
	@Override
	public List<SystemResource> getChildMenusByUserId(String userId,String parentId, MenuType menuType) {
		return systemResourceMapper.getChildMenusByUserId(userId, parentId, menuType.toString());
	}

	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ResourceService#hasResourceByRoleId(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean hasResourceByRoleId(String roleid, String resid) {
		return this.getRecordByResIdAndRoleId(roleid, resid)>0;
	}

	
	
	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#deleteById(java.lang.String)
	 */
	@Override
	public int deleteById(String id) {
		List<SystemResource> btns = getChildren(id,MenuType.BUTTON);
		
		List<SystemResource> menus = new ArrayList<SystemResource>();
		
		List<SystemResource> children = getChildren(id,MenuType.MODULE);
		
		getAllChildResource(children,menus);
		getButtonsByMenuid(children,btns);
		
		children.addAll(btns);
		children.addAll(menus);
		
		List<String> ids = new ArrayList<String>();
		for (SystemResource res : children) {
			ids.add(res.getId());
		}
		
		ids.add(id);
		
		SystemResourceSearch search = new SystemResourceSearch();
		search.createCriteria().andIdIn(ids);
		return deleteByExample(search);
	}

	/**
	 * 递归查找所有的子菜单
	 * @param children
	 * @param menus
	 */
	private void getAllChildResource(List<SystemResource> children,List<SystemResource> menus){
		for (SystemResource systemResource : children) {
			List<SystemResource> chs = getChildren(systemResource.getId(),MenuType.MODULE);
			menus.addAll(chs);
			getAllChildResource(chs, menus);
		}
	}
	
	/***
	 * 递归查找按钮
	 * @param children
	 * @param btns
	 */
	private void getButtonsByMenuid(List<SystemResource> children,List<SystemResource> btns){
		for (SystemResource systemResource : children) {
			List<SystemResource> childrens = getChildren(systemResource.getId(),MenuType.BUTTON);
			if(childrens!=null && !childrens.isEmpty()){
				btns.addAll(childrens);
			}else{
				getButtonsByMenuid(getChildren(systemResource.getId(),MenuType.MODULE),btns);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#save(java.lang.Object)
	 */
	@Override
	public int save(SystemResource record) {
		if (StringUtils.isEmpty(record.getId())) {
			record.setId(UuidGenerateUtil.getUUIDLong());
		}
		record.setDisabled(false);
		record.setCreateBy(SpringSecurityUtils.getCurrentUserName());
		record.setUpdateBy(SpringSecurityUtils.getCurrentUserName());
		record.setCreateDate(new Date());
		record.setStatus("0");
		return systemResourceMapper.insertSelective(record);
	}

	@Override
	public List<SystemResource> getChildMenusByUserIdAndParentId(String userId,
			String parentId) {
		return systemResourceMapper.getChildMenusByUserIdAndParentId(userId, parentId);
	}

	@Override
	public void deleteResourceByRoleId(String roleid) {
		systemResourceMapper.deleteResourceByRoleId(roleid);
	}

	@Override
	public void addRoleResource(String roleid, String resid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("resourceId", resid);
		args.put("roleId", roleid);
		systemResourceMapper.addRoleResource(args);
	}

	@Override
	public void deleteRoleResource(String roleid, String resid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("resourceId", resid);
		args.put("roleId", roleid);
		systemResourceMapper.deleteRoleResource(args);
	}

	@Override
	public int getRecordByResIdAndRoleId(String roleid, String resid) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("resourceId", resid);
		args.put("roleId", roleid);
		return systemResourceMapper.getRecordByResIdAndRoleId(args);
	}

	@Override
	public void getUserModule(String userid, HttpServletRequest request) {
		List<SystemResource> menus = this.getChildMenusByUserId(userid, "0", MenuType.MODULE);//.getMenusByUserId(, MenuType.MODULE);
        List<SystemResource> oneLevel = new ArrayList<SystemResource>();
        
        for (SystemResource menu : menus) {
            // 寻找一级菜单
            if ("0".equals(menu.getParentid())) {
                oneLevel.add(menu);
            }
        }
        
        List<String> list = systemUserResourceService.getList(userid);
        if (list != null && list.size() > 0) {
        	Map<String, SystemResource> map = new HashMap<String, SystemResource>();
        	for (SystemResource sr : oneLevel) {
        		map.put(sr.getId(), sr);
        	}
        	oneLevel.clear();
        	for (String str : list) {
        		oneLevel.add(map.get(str));
        	}
        } 
        
        JsonArray array = new JsonArray();
        JsonObject obj = null;
        for (SystemResource menu : oneLevel) {
        	obj = new JsonObject();
            obj.addProperty("id", menu.getId());
            obj.addProperty("title", menu.getName());
            obj.addProperty("url", menu.getContent());
            obj.addProperty("img", menu.getCode());
            array.add(obj);
        }
        
        request.getSession().setAttribute("one_menus", oneLevel);
        request.getSession().setAttribute("one_menus_json", array.toString());
	}
	
}
