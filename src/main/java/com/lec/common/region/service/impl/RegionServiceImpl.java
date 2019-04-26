package com.lec.common.region.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lec.common.region.cache.RegionCache;
import com.lec.common.region.dao.RegionMapper;
import com.lec.common.region.service.RegionService;
import com.lec.common.region.vo.Region;
import com.lec.common.region.vo.RegionSearch;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.cache.Cache;
import com.lec.framework.util.StringUtils;

@Service
public class RegionServiceImpl extends AbstractBaseService<Region, RegionSearch> implements RegionService {
    
	@Resource
    RegionMapper regionMapper;

	@Resource
    Cache cache;
	
    @Override
    public BaseMapper<Region, RegionSearch> getBaseMapper() {
         return regionMapper;
    }
    
    @Override
	public String makeTreeData() {
		@SuppressWarnings("unchecked")
		List<Region> list = (List<Region>)cache.get(RegionCache.ALL_ITEM);
		
		JsonArray array = new JsonArray();
		
		JsonObject obj = new JsonObject();
		for (Region region : list) {
			obj = new JsonObject();
			obj.addProperty("id", region.getId());
			obj.addProperty("pId", region.getPid());
			obj.addProperty("name", region.getName());
			array.add(obj);
		}
		return array.toString();
	}

	@Override
	public int deleteById(String id) {
		int isOK = super.deleteById(id);
		this.refreshCache();
		return isOK;
	}

	@Override
	public int save(Region record) {
		int isOK = super.save(record);
		this.refreshCache();
		return isOK;
	}

	@Override
	public int updateByIdSelective(Region record) {
		int isOK = super.updateByIdSelective(record);
		this.refreshCache();
		return isOK;
	}

	@Override
	public void refreshCache() {
		RegionSearch search = new RegionSearch();
		search.setOrderByClause("PID ASC, SORT ASC");
		
		List<Region> list = this.selectByExample(search);
		
		Table<String, String, String> table = HashBasedTable.create();
        Table<String, String, String> table2 = HashBasedTable.create();
        Table<String, String, String> table3 = HashBasedTable.create();
        Table<String, String, Region> table4 = HashBasedTable.create();
        for (Region r : list) {
            table.put(r.getId(), RegionCache.ID_NAME, r.getName());
            table2.put(r.getId(), RegionCache.ID_FULLNAME, this.getFullNameById(r.getId()));
            table3.put(r.getId(), RegionCache.ID_LOCATION, r.getLongitude()+","+r.getLatitude());
            table4.put(r.getId(), RegionCache.ID_OBJ, r);
        }
        cache.put(RegionCache.ID_NAME,table);
        cache.put(RegionCache.ID_FULLNAME,table2);
        cache.put(RegionCache.ID_LOCATION,table3);
        cache.put(RegionCache.ID_OBJ,table4);
        cache.put(RegionCache.ALL_ITEM, list);
	}

	@Override
	public String getFullNameById(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", id);
		List<Map<String,Object>> list = regionMapper.getFullNameById(args);
		if (list == null || list.size() == 0) {
			return null;
		}
		StringBuilder str = new StringBuilder();
		for (Map<String,Object> m : list) {
			str.append(m.get("NAME"));
		}
		return str.toString();
	}
    
}