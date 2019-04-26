package com.lec.common.user.cache;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lec.common.deptment.service.DepartmentService;
import com.lec.framework.cache.BaseCache;
import com.lec.framework.cache.Cache;
import com.lec.framework.log.Logging;
/***
 * 组织机构缓存
 * @author zhouhaij
 * @Apr 19, 2013 2:04:23 PM
 */
@Component
public class DepartmentCache implements BaseCache{
	private final Logging logger = new Logging(DepartmentCache.class);
	
	public final static String DEPARTMENT_CACHE ="department_cache";
	public final static String DEPARTMENTCODE_CACHE ="departmentcode_cache";
	
	@Resource
	Cache cache;

	@Resource
	DepartmentService departmentService;
	
	@Override
	public String getCacheKey() {
		return DIC_CACHE;
	}

	@Override
	public void init() throws Exception {
		departmentService.refreshCache();
		logger.info("[部门信息] 缓存初始化完成");
	}

}
