package com.lec.common.system.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Table;
import com.lec.common.log.service.OperateLogService;
import com.lec.common.user.cache.RoleCache;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.cache.Cache;
import com.lec.core.security.OperatorDetails;

/**
 * 系统设置主页
 * @author HaoXiang
 * 2017年8月14日
 */
@Controller
public class HomeSettingCtl extends BaseCtl {

	@Resource
	OperateLogService operateLogService;
	@Resource
	Cache cache;
	
	@RequestMapping(value = "home/setting/index/")
	public String index(@RequestParam(value = "pageSize", defaultValue = "6") int pageSize,
			HttpServletRequest request, Model model) {
		Page page = operateLogService.getLogsByCondition(new HashMap<String, Object>(), 1, pageSize, "ID DESC");
		model.addAttribute("logPage", page);
		model.addAttribute("user", super.getCurrentUser());
		
		@SuppressWarnings("unchecked")
		Table<String, String, String> table = (Table<String, String, String>)cache.get(RoleCache.CODE_NAME);
		Map<String, String> map = table.column(RoleCache.CODE_NAME);
		
		OperatorDetails od = super.getCurrentUser();
		Collection<GrantedAuthority> cn = od.getAuthorities();
		
		StringBuilder roles = new StringBuilder();
		for (GrantedAuthority g : cn) {
			roles.append(map.get(g.getAuthority()));
			roles.append(",");
		}
		if (roles.length() > 0) {
			model.addAttribute("roles", roles.substring(0, roles.length()-1));
		}
		
		return "home/sys_main";
	}
	
}
