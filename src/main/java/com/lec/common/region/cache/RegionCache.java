package com.lec.common.region.cache;

import javax.annotation.Resource;

import com.lec.common.region.service.RegionService;
import com.lec.framework.cache.BaseCache;
import com.lec.framework.log.Logging;

public class RegionCache implements BaseCache {

	private final Logging logger = new Logging(this.getClass());
	/**
	 * 根据ID获取名称
	 */
	public final static String ID_NAME = "REGION_NAME";
	/**
	 * 根据ID获取全名称
	 */
    public final static String ID_FULLNAME = "REGION_FULL_NAME";
    /**
     * 根据ID获取坐标值：经度,纬度
     */
    public final static String ID_LOCATION = "REGION_LOCATION";
    /**
     * 根据ID获取对象
     */
    public final static String ID_OBJ = "REGION_OBJ";
    /**
     * 所有数据
     */
    public final static String ALL_ITEM = "REGION_ALL";
	
	@Resource
    RegionService regionService;
	
	@Override
	public String getCacheKey() {
		return DIC_CACHE;
	}

	@Override
	public void init() throws Exception {
		regionService.refreshCache();
        logger.info("[行政区域] 缓存初始化完成");
	}

}
