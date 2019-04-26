package com.lec.common.system.dao;

import java.util.List;
import java.util.Map;

import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceSearch;
import com.lec.framework.base.BaseMapper;

/***
 * 系统资源映射器
 * @author zhouhaij
 *
 */
public interface SystemResourceMapper extends BaseMapper<SystemResource,SystemResourceSearch>{
	/***
	 *  根据用户id获取桌面菜单
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getDeskTopMenuByuserId(String userId);
	
	/***
	 * 获取用户拥有的菜单权限
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getMenusByUserId(String userId, String menuType);
	
	
	/***
	 * 获取用户拥有的所有的叶菜单
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getLeafMenusByUserId(String userId);


    public List<SystemResource> getAllResourceByUserId(String userId);
	
	/***
	 * 获取用户拥有的子菜单
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getChildMenusByUserId(String userId, String parentId, String menuType);
	
	/***
	 * 根据用户以及菜单编号获取按钮的名称
	 * @param userId
	 * @param menuId
	 * @return
	 */
	public List<String> getMenuButtonsByParentId(String userId, String menuId);
	
	/***
	 * 根据角色id删除与资源的关系
	 * @param roleid
	 */
	public void deleteResourceByRoleId(String roleid);
	
	/***
	 * 添加角色与资源的关系
	 * @param roleid
	 * @param resid
	 */
	public void addRoleResource(Map<String, Object> args);

	/***
	 * 删除角色与资源的关系
	 * @param roleid
	 * @param resid
	 */
	public void deleteRoleResource(Map<String, Object> args);
	
	/***
	 * 根据角色id和资源id查找是否有记录
	 * @param roleid
	 * @return
	 */
	public int getRecordByResIdAndRoleId(Map<String, Object> args);

	/**
	 * 熊杰添加<br/>
	 * 根据用户权限和指定的父菜单id查找所有子菜单，不包括操作权限
	 * @param userId
	 * @param parentId
	 * @return
	 */
	public List<SystemResource> getChildMenusByUserIdAndParentId(String userId, String parentId);
}