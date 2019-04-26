package com.lec.common.region.dao;

import java.util.List;
import java.util.Map;

import com.lec.common.region.vo.Region;
import com.lec.common.region.vo.RegionSearch;
import com.lec.framework.base.BaseMapper;

public interface RegionMapper extends BaseMapper<Region, RegionSearch> {
	
	List<Map<String,Object>> getFullNameById(Map<String, Object> args);
}