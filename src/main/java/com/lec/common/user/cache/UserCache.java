package com.lec.common.user.cache;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lec.common.user.service.UserService;
import com.lec.framework.cache.BaseCache;
import com.lec.framework.cache.Cache;
import com.lec.framework.log.Logging;

/**
 * 用户缓存
 * @author zhouhaij
 * @Apr 19, 2013 1:58:36 PM
 */
@Component
public class UserCache implements BaseCache {
	private final Logging logger = new Logging(UserCache.class);
	public final static String USERNAME_CACHE ="username_cache";
	@Resource 
	UserService userService;
	
	@Resource
	Cache cache;

	/* (non-Javadoc)
	 * @see com.lec.framework.cache.BaseCache#getCacheKey()
	 */
	@Override
	public String getCacheKey() {
		return DIC_CACHE;
	}

	/* (non-Javadoc)
	 * @see com.lec.framework.cache.BaseCache#init()
	 */
	@Override
	public void init() throws Exception {
		userService.refreshCache();
		logger.info("[用户信息] 缓存初始化完成");
	}

}
