package com.lec.common.user.cache;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lec.common.user.service.RoleService;
import com.lec.common.user.vo.Role;
import com.lec.framework.cache.BaseCache;
import com.lec.framework.log.Logging;

/***
 * 角色缓存
 * @author zhouhaij
 * @Apr 19, 2013 2:58:37 PM
 */
@Component
public class RoleCache implements BaseCache{
	private final Logging logger = new Logging(RoleCache.class);
	
	public static final String ID_NAME = Role.class.getSimpleName();
	public static final String CODE_NAME = "RoleCodeName";
	
	@Resource
	RoleService roleService;
	
	@Override
	public String getCacheKey() {
		return DIC_CACHE;
	}

	@Override
	public void init() throws Exception {
		roleService.refreshCache();
		logger.info("[角色缓存] 初始化完成");
	}

}
