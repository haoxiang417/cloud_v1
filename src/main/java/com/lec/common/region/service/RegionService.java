package com.lec.common.region.service;

import com.lec.common.region.vo.Region;
import com.lec.common.region.vo.RegionSearch;
import com.lec.core.service.BaseService;

public interface RegionService extends BaseService<Region, RegionSearch> {
	
	/**
	 * 生成树形数据
	 * @return
	 */
	String makeTreeData();
	
	/**
	 * 刷新缓存
	 */
	void refreshCache();
	
	/**
	 * 获取区域全名
	 * @param id
	 * @return
	 */
	String getFullNameById(String id);
}