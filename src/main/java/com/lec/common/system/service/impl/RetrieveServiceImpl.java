package com.lec.common.system.service.impl;



import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.common.system.dao.RetrieveInfoMapper;
import com.lec.common.system.service.RetrieveService;
import com.lec.common.system.vo.RetrieveInfo;
import com.lec.common.system.vo.RetrieveInfoSearch;
import com.lec.common.system.vo.RetrieveInfoSearch.Criteria;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.base.Page;
import com.lec.framework.util.DateUtil;
import com.lec.framework.util.StringUtils;


/***
 * 系统回收站相关 服务接口类
 * @author yantao
 */

@Service("retrieveService")
public class RetrieveServiceImpl extends AbstractBaseService<RetrieveInfo, RetrieveInfoSearch> implements RetrieveService {

	@Resource
	RetrieveInfoMapper retrieveInfoMapper;
	
	@Override
	protected BaseMapper<RetrieveInfo, RetrieveInfoSearch> getBaseMapper() {
		return retrieveInfoMapper;
	}
	
	
	@Override
	public Page getByCondition(Map<String, Object> map,int pageNo,int pageSize, String sortType) {
		RetrieveInfoSearch search = new RetrieveInfoSearch();
		Criteria criteria = search.createCriteria();
		if(map!=null){
			if(StringUtils.notEmpty(map.get("operator")+"")){
				criteria.andOperatorLike("%"+map.get("operator").toString()+"%");
			}
			if(StringUtils.notEmpty(map.get("startTime")+"")){
				Date sdate = DateUtil.stringFormatToDate(map.get("startTime").toString(), "yyyy-MM-dd HH:mm:SS");
				criteria.andDeltimeGreaterThanOrEqualTo(sdate);
			}
			if(StringUtils.notEmpty(map.get("endTime")+"")){
				Date edate = DateUtil.stringFormatToDate(map.get("endTime").toString(), "yyyy-MM-dd HH:mm:SS");
				criteria.andDeltimeLessThanOrEqualTo(edate);
			}
		}
		if(StringUtils.notEmpty(sortType)){
			search.setOrderByClause(sortType);
		}
		Page page = selectByExample(search, pageNo, pageSize);
		return page;
	}
	
	@Override
	public List<RetrieveInfo> findAll() {
		RetrieveInfoSearch search = new RetrieveInfoSearch();
		search.createCriteria().andIdIsNotNull();
		return retrieveInfoMapper.selectByExample(search);
	}
	
	
}
