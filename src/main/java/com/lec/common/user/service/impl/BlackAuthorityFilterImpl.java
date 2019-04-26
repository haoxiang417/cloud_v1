package com.lec.common.user.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.lec.common.deptment.vo.Department;
import com.lec.common.system.service.ParamsService;
import com.lec.common.system.vo.SystemResource;
import com.lec.common.user.cache.AuthorityMenuCache;
import com.lec.common.user.service.BlackAuthorityFilter;
import com.lec.framework.cache.Cache;
import com.lec.core.security.OperatorDetails;
import com.lec.framework.security.SpringSecurityUtils;
/**
 * <p>业务模块中根据orgId来进行数据权限的过滤</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
@Service
public class BlackAuthorityFilterImpl extends AbstractAuthorityContext implements BlackAuthorityFilter{
	
	@Resource
	Cache cache;

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.GpsAuthorityFilter#isGpsModule(java.lang.String)
	 */
	@Override
	public boolean isBlackModule(String menuid) {
		List<SystemResource> res = getModuleMap().get("black");
		boolean isBlack = false;
		for (SystemResource systemResource : res) {
			if(systemResource.getId().equals(menuid)){
				isBlack = true;
				break;
			}
		}
		return isBlack;
	}

	/* (non-Javadoc)
	 */
	@Override
	public boolean isEnable(String menuid) {
		return "1".equals(ParamsService.SYSTEM_PARAMS.get("isBlack"));
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.impl.AbstractAuthorityContext#getBasePerssionSQL()
	 */
	@Override
	protected String getBasePerssionSQL() {
		OperatorDetails details = SpringSecurityUtils.getCurrentUser();
		//获取当前部门的子部门
		List<Department> departs = getAllDepartmentByUserId(details.getDeptId());
		List<String>  ids= new ArrayList<String>();
		Set<String> idSet = new HashSet<String>();
		for (int i = 0; i < departs.size(); i++) {
			idSet.add(departs.get(i).getId());
		}
		for (String string : idSet) {
			ids.add(string);
		}
		String[] code = toCodes(ids);
		if(code==null){
			return null;
		}
		if(ids.size()>800){
			return MessageFormat.format(UserAuthoritySQL.ORG_AUTHORITY_SQL,code[0],code[1],code[2]);
		}
		return MessageFormat.format(UserAuthoritySQL.BASE_AUTHORITY_SQL,code[0]);

	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.impl.AbstractAuthorityContext#getBasePerssionExtSQL(java.lang.String)
	 */
	@Override
	protected String getBasePerssionExtSQL(String menuid) {
		//key为部门id
		Map<String, List<String>>  map = getUsersAuthorityMap(menuid);
		List<String>  ids= new ArrayList<String>();
		Set<String> idSet = new HashSet<String>();
		//去掉重复
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String type = (String) it.next();
			idSet.add(type);
		}
		
		for (String string : idSet) {
			ids.add(string);
		}
		
		String[] code = toCodes(ids);
		if(ids.isEmpty()){
			return null;
		}
		
		if(ids.size()>800){
			return MessageFormat.format(UserAuthoritySQL.ORG_AUTHORITY_SQL,code[0],code[1],code[2]);
		}
		
		return MessageFormat.format(UserAuthoritySQL.BASE_AUTHORITY_SQL,code[0]);
	}
	
	//将ORGID分成3份
	private String[] toCodes(List<String> list){
		//初始化
		String[] str = new String[]{"a","b","c"};
		int iterator = 1;
		Multimap<String, String> multimap = HashMultimap.create();
		if(list.size()>800){
			iterator=3;
			for (int i=0;i< list.size();i++) {
				String node = str[i%3];
				multimap.put(node,list.get(i));
			}
		}else{
			for (int i=0;i< list.size();i++) {
				multimap.put("a",list.get(i));
			}
		}
		
		for (int i = 0; i < iterator; i++) {
			StringBuilder sb = new StringBuilder();
			for (String string : multimap.get(str[i])) {
				sb.append("'"+string+"',");
			}
			str[i] = StringUtils.removeEnd(sb.toString(),",");
		}
		return str;
	}
	
	/***
	 * 获取模块类型对应的菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String,List<SystemResource>> getModuleMap() {
		return (Map<String, List<SystemResource>>) cache.get(AuthorityMenuCache.AUTHORITY_MENUS);
	}

}
