package com.lec.common.system.service;


import java.util.List;
import java.util.Map;

import com.lec.common.system.vo.RetrieveInfo;
import com.lec.common.system.vo.RetrieveInfoSearch;
import com.lec.core.service.BaseService;
import com.lec.framework.base.Page;

/***
 * 系统回收站相关 服务接口类
 * 
 * @author yantao
 */
public interface RetrieveService extends BaseService<RetrieveInfo, RetrieveInfoSearch> {

	
	public Page getByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);
	
	public List<RetrieveInfo> findAll();
	
}
