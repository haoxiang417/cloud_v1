package com.lec.common.user.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.lec.common.deptment.service.DepartmentService;
import com.lec.common.deptment.vo.Department;
import com.lec.common.system.service.ParamsService;
import com.lec.common.user.service.AuthorityFilterContext;
import com.lec.common.user.service.UserAuthorityService;
import com.lec.common.user.vo.UserAuthority;
import com.lec.core.security.OperatorDetails;
import com.lec.framework.security.SpringSecurityUtils;


/**
 * <p>数据权限过滤的抽象类</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public abstract class AbstractAuthorityContext implements AuthorityFilterContext{
	
	@Resource
	DepartmentService departmentService;

	@Resource(name="userAuthorityServiceImpl")
	UserAuthorityService userAuthorityService;
	
	/**
	 * 权限处理返回sql字符串
	 */
	@Override
	public String filterSql(String menuid) {
		// 如果未开启部门权限扩展控制，则直接返回
		if (!authorityEnable()) {
			return "";
		}

		// 如果此菜单在数据权限中,说明是在数据权限的功能限定菜单
		if (!authorityMapIsEmpty()) {
			//如果此菜单所在的模块未开启数据权限，则按基础的默认权限处理
			if(!isEnable(menuid) || !contains(menuid)){
				return getBasePerssionSQL();
			}
			String extSQL = getBasePerssionExtSQL(menuid);
			//如果权限扩展的部门为空,则按基础权限处理
			if(StringUtils.isBlank(extSQL)){
				extSQL =  getBasePerssionSQL();
			}
			return extSQL;
		}
		return getBasePerssionSQL();
	
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lec.common.user.service.DepartmentAuthorityFilter#filter
	 * (java.util.Map, java.lang.String)
	 */
	@Override
	public Map<String, Object> filter(Map<String, Object> map, String menuid) {
		// 如果未开启部门权限扩展控制，则直接返回
		if (!authorityEnable()) {
			return map;
		}

		// 如果此菜单在数据权限中,说明是在数据权限的功能限定菜单
		if (!authorityMapIsEmpty()) {
			//如果此菜单所在的模块未开启数据权限，则按基础的默认权限处理
			if(!isEnable(menuid) || !contains(menuid)){
				map.put(DEPARTMENT_KEY, getBasePerssionSQL());
				return map;
			}
			String extSQL = getBasePerssionExtSQL(menuid);
			//如果权限扩展的部门为空,则按基础权限处理
			if(StringUtils.isBlank(extSQL)){
				extSQL =  getBasePerssionSQL();
			}
			map.put(DEPARTMENT_KEY,extSQL);
			return map;
		}

		map.put(DEPARTMENT_KEY, getBasePerssionSQL());
		return map;
	}
	

	//子类实现     默认权限的子查询sql语句
	protected abstract String getBasePerssionSQL();
	
	
	//子类实现     默认权限扩展的子查询sql语句
	protected abstract String getBasePerssionExtSQL(String menuid);
	
	/***
	 * 各个业务功能是否打开对应的数据权限
	 * @param menuid
	 * @return
	 */
	protected abstract  boolean isEnable(String menuid);
	
	/***
	 * 获取部门权限控制是否开启
	 * @return
	 */
	protected boolean authorityEnable() {
		// 获取系统参数
		String isStartCtl = ParamsService.SYSTEM_PARAMS.get("isStartDepartControl");
		return "1".equals(isStartCtl);
	}
	
	/***
	 * 获取部门权限控制是否开启
	 * @return
	 */
	protected boolean authorityIsBlankDeviceShowAll() {
		// 获取系统参数isBlankDeviceShowAll
		String isStartCtl = ParamsService.SYSTEM_PARAMS.get("isBlankDeviceShowAll");
		return "1".equals(isStartCtl);
	}
	/***
	 * 监控数据权限是否开启
	 * @return
	 */
	protected boolean videoEnable() {
		return "1".equals(ParamsService.SYSTEM_PARAMS.get("isVideo"));
	}
	
	/***
	 * 获取用户的部门菜单map
	 * @return
	 */
	protected Map<String, List<String>>  getUsersAuthorityMap(String menuid) {
		OperatorDetails details = SpringSecurityUtils.getCurrentUser();
		List<UserAuthority>  authority = userAuthorityService.getDeptIdByUserId(details.getId());
        Table<String, String,List<String>> table = HashBasedTable.create();
        for (UserAuthority userAuthority : authority) {
        	List<String> menuList = table.row(userAuthority.getUserid()).get(userAuthority.getDeptid());
        	if(menuList == null){
        		menuList = new ArrayList<String>();
        		table.put(userAuthority.getUserid(),userAuthority.getDeptid(),menuList);
        	}else{
        		menuList.add(userAuthority.getMenuid());
        	}
		}
		//此处代码有数据检测bug
		Map<String, List<String>> deptMenuMap = table.row(details.getId());
		if(menuid==null){
			return deptMenuMap;
		}
		for (Iterator<String> iterator = deptMenuMap.keySet().iterator(); iterator.hasNext();) {
			String deptid = (String) iterator.next();
			List<String> menus = deptMenuMap.get(deptid);
			//如果菜单列表中没有此菜单,则表示当前用户没有此部门的查看权限，删除此部门的记录
			if(!menus.contains(menuid)){
				iterator.remove();
			}
		}
		return deptMenuMap;
	}
	
	/***
	 * 用户的数据权限是否为空
	 * @return
	 */
	protected boolean authorityMapIsEmpty() {
		OperatorDetails details = SpringSecurityUtils.getCurrentUser();
		List<UserAuthority>  authority = userAuthorityService.getDeptIdByUserId(details.getId());
		if(authority==null) return true;
		if(authority.isEmpty()) return true;
		return false;
	}
	
	/***
	 * 菜单是否在数据权限的范围内
	 * @param menuid
	 * @return
	 */
	protected boolean contains(String menuid) {
		Map<String, List<String>>  map = getUsersAuthorityMap(menuid);
		//判断用户是否有此菜单的数据权限
		boolean isHasAuthority = false;
	    for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
	    	String key = ( String) iterator.next();
	    	List<String> list = map.get(key);
			 if(list.contains(menuid)){
				 isHasAuthority = true;
				 break;
			 }
		}
	    return isHasAuthority;
	}
	

	/***
	 * 获取用户的部门sql
	 * @return
	 */
	protected String getDeptSQL() {
		OperatorDetails details = SpringSecurityUtils.getCurrentUser();
		String userid = "'" + details.getId() + "'";
		return MessageFormat.format(UserAuthoritySQL.DEPT_SQL, userid, userid, userid, userid);
	}
	
	/***
	 * 获取数据权限的sql
	 * @param menuid
	 * @return
	 */
	protected String getPermissonSQL(String menuid){
		OperatorDetails details = SpringSecurityUtils.getCurrentUser();
		return MessageFormat.format(UserAuthoritySQL.PERMISSION_AUTHORITY_SQL, "'" + details.getId() + "'", "'" + menuid + "'");
	}
	
	/***
	 * 用户的部门以及子部门
	 * @param deptid
	 * @return
	 */
	protected List<Department> getAllDepartmentByUserId(String deptid){
		// 找出当前部门的子部门
		List<Department> departs = new ArrayList<Department>();
		getAllChildren(departs, deptid);
		return departs;
	}
	
	/***
	 * 递归查找部门的所有子部门
	 * 
	 * @param resultList
	 * @param deptid
	 */
	private void getAllChildren(List<Department> resultList, String deptid) {
		// 添加其自身部门
		resultList.add(departmentService.getById(deptid));
		// 找出当前部门的子部门
		List<Department> departs = departmentService.getChildren(deptid);

		if (departs != null && !departs.isEmpty()) {
			resultList.addAll(departs);
			for (Department department : departs) {
				getAllChildren(resultList, department.getId());
			}
		}
	}
	
	
	/***
	 * 用户的部门以及父亲部门
	 * @param deptid
	 * @return
	 */
	protected List<Department> getAllDepartmentParnetByUserId(String deptid){
		// 找出当前部门的子部门
		List<Department> departs = new ArrayList<Department>();
		getAllParent(departs, deptid);
		return departs;
	}
	
	/***
	 * 递归查找部门的所有父亲部门
	 * 
	 * @param resultList
	 * @param deptid
	 */
	private void getAllParent(List<Department> resultList, String deptid) {
		// 添加其自身部门
		resultList.add(departmentService.getById(deptid));
		String parentId = departmentService.getParentIdById(deptid);
		Department departs = departmentService.getById(parentId);
		// 找出当前部门的子部门
//		List<Department> departs = departmentService.getChildren(deptid);

		if (departs != null ) {
			//resultList.addAll(departs);
			//for (Department department : departs) {
				getAllParent(resultList, departs.getId());
			//}
		}
	}
	
}
