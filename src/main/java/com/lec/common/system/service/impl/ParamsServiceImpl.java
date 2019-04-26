package com.lec.common.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.common.system.dao.SystemParamsMapper;
import com.lec.common.system.service.ParamsService;
import com.lec.common.system.vo.SystemParams;
import com.lec.common.system.vo.SystemParamsSearch;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;

@Service
public class ParamsServiceImpl extends AbstractBaseService<SystemParams, SystemParamsSearch> implements ParamsService {

	@Resource
	SystemParamsMapper systemParamsMapper;
	
	@Override
	protected BaseMapper<SystemParams, SystemParamsSearch> getBaseMapper() {
		return systemParamsMapper;
	}

	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ParamsService#getParamsByKeyAndType(java.lang.String, java.lang.String)
	 */
	@Override
	public SystemParams getParamsByKeyAndType(String key, String type) {
		SystemParamsSearch search = new SystemParamsSearch();
		search.createCriteria().andTypesEqualTo(type)
		.andNameEqualTo(key);
		List<SystemParams> list = systemParamsMapper.selectByExample(search);
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lec.common.system.service.ParamsService#getAllParams(java.lang.String)
	 */
	@Override
	public Map<String,String> getAllParams(String type) {
		SystemParamsSearch search = new SystemParamsSearch();
		search.createCriteria().andNameIsNotNull().andTypesEqualTo(type);
		List<SystemParams> list = systemParamsMapper.selectByExample(search);
		Map<String,String> resultMap = new HashMap<String,String>();
		if(list!=null  && !list.isEmpty()){
			for (SystemParams systemParams : list) {
				resultMap.put(systemParams.getName(), systemParams.getValue());
			}
		}
		return resultMap;
	}

	
	
	
}
