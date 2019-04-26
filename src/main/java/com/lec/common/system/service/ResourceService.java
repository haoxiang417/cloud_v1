package com.lec.common.system.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceSearch;
import com.lec.common.user.type.MenuType;
import com.lec.core.service.BaseService;

/***
 * 系统资源服务接口
 * @author zhouhaij
 */
public interface ResourceService extends BaseService<SystemResource,SystemResourceSearch>{
	
	public List<SystemResource> findAll(boolean disabled);
	
	/***
	 * 获取所有的菜单
	 * @param keyword
	 * @return
	 */
	public List<SystemResource> findAllMenuByKeyWord(String keyWord, String exIncludes);
	
	/**
	 * 获取资源的孩子节点
	 * @param menuid
	 * @return
	 */
	public List<SystemResource> getChildren(String menuid, MenuType type);
	
	/***
	 * 判断该资源是否有孩子
	 * @param menuid
	 * @return
	 */
	public boolean hasChild(String menuid, MenuType type);
	/***
	 * 获取用户拥有的菜单权限
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getMenusByUserId(String userId, MenuType menuType);
	/***
	 * 获取用户拥有的菜单权限
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getChildMenusByUserId(String userId, String parentId, MenuType menuType);
	/***
	 * 获取用户拥有的所有的叶菜单
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getLeafMenusByUserId(String userId);

    /***
     * 获取用户拥有所有资源
     * @param userId
     * @return
     */
    public List<SystemResource> getAllResourceByUserId(String userId);
	
	/***
	 *  获取用户拥有的快捷方式
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getDeskTopMenuByuserId(String userId);
	/****
	 * 获取menu下的所有按钮
	 * @param userId
	 * @param menuId
	 * @return
	 */
	public List<String> getMenuButtonsByParentId(String userId, String menuId);
	
	/***
	 * 
	 * @param userId
	 * @return
	 */
	public List<SystemResource> getMenuButtonsByUserId(String userId);
	
	/***
	 * 授权角色资源
	 * @param roleid
	 * @param resid
	 */
	public void grantRoleResource(String roleid, String... resid);
	
	
	/***
	 * 根据角色id和资源id查找是否有记录
	 * @param roleid
	 * @return
	 */
	public boolean hasResourceByRoleId(String roleid, String resid);
	
	/**
	 * 熊杰添加<br/>
	 * 根据用户权限和菜单名称获取所有子菜单，不包括操作资源
	 * @param userId 对应用户的id
	 * @param parentId 父模块id
	 * @return
	 */
	public List<SystemResource> getChildMenusByUserIdAndParentId(String userId, String parentId);
	
	
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
	public void addRoleResource(String roleid, String resid);

	/***
	 * 删除角色与资源的关系
	 * @param roleid
	 * @param resid
	 */
	public void deleteRoleResource(String roleid, String resid);
	
	/***
	 * 根据角色id和资源id查找是否有记录
	 * @param roleid
	 * @return
	 */
	public int getRecordByResIdAndRoleId(String roleid, String resid);
	
	/**
	 * 获取用户模块列表，并存入session
	 * @param userid
	 * @param request
	 */
	public void getUserModule(String userid, HttpServletRequest request);
	
}
