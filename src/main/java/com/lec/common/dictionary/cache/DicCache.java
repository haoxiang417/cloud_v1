package com.lec.common.dictionary.cache;

import javax.annotation.Resource;

import com.lec.common.dictionary.service.DicService;
import com.lec.common.dictionary.vo.Dic;
import com.lec.framework.cache.BaseCache;
import com.lec.framework.log.Logging;

/**
 * 数据字典缓存
 * @author zhouhaij
 * @Apr 19, 2013 3:52:33 PM
 */
public class DicCache implements BaseCache {
	private final Logging logger = new Logging(DicCache.class);
	
	public static final String TYPE_CODE_NAME = Dic.class.getSimpleName();
	
	public static final String TYPE_LIST = "Dic_Type_List";
	
	@Resource
	DicService dicService;

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
		dicService.refreshCache();
		logger.info("[数据字典] 缓存初始化完成");
	}

}
