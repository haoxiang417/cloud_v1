package com.lec.common.log.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.common.log.dao.SystemLogMapper;
import com.lec.common.log.service.SystemLogService;
import com.lec.common.log.vo.SystemLog;
import com.lec.common.log.vo.SystemLogSearch;
import com.lec.common.log.vo.SystemLogSearch.Criteria;
import com.lec.core.security.OperatorDetails;
import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.base.Page;
import com.lec.framework.util.DateUtil;

/***
 * 登录日志服务接口
 * @author zhouhaij
 * @Apr 28, 2013 9:08:37 AM
 */
@Service
public class SystemLogServiceImpl extends AbstractBaseService<SystemLog,SystemLogSearch>implements SystemLogService {

	@Resource
	SystemLogMapper systemLogMapper;
	
	@Override
	@Transactional
	public int save(SystemLog log) {
		return systemLogMapper.insertSelective(log);
	}

	public SystemLog getById(String id){
		SystemLogSearch search = new SystemLogSearch();
		Criteria criteria = search.createCriteria();
		criteria.andIdEqualTo(id);
		return selectByExample(search).get(0);
	}
	
	
	/* (non-Javadoc)
	 * @see com.lec.common.log.service.SystemLogService#getSystemLogsByCondition(java.util.Map, int, int, java.lang.String)
	 */
	@Override
	public Page getSystemLogsByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType) {
		Map<String, Object> args = new HashMap<String, Object>();
    	args.putAll(map);
    	
    	if (args.containsKey("startDate") && args.containsKey("endDate") 
    			&& args.get("startDate").equals(args.get("endDate"))) {
    		args.put("startDate", args.get("startDate") + " 00:00:00");
    		args.put("endDate", args.get("endDate") + " 23:59:59");
    	}
        List<SystemLog> results = systemLogMapper.selectLogs(args, Page.getRowBounds(pageNo, pageSize));
        int totalCount = systemLogMapper.countLogs(args);
        return Page.getPage(totalCount, results, pageNo, pageSize);
	}
	
	
	/* (non-Javadoc)
	 * @see com.lec.common.log.service.SystemLogService#getLastLogInfo(com.lec.framework.security.OperatorDetails)
	 */
	@Override
	public SystemLog getLastLogInfo(OperatorDetails operator) {
		return systemLogMapper.selectLastLogUser(operator.getAccount(),DateUtil.formatDate(com.lec.framework.constant.FORMAT.DATETIME.DEFAULT,operator.getLoginTime()));
	}


	/* (non-Javadoc)
	 * @see com.lec.core.service.AbstractBaseService#getBaseMapper()
	 */
	@Override
	protected BaseMapper<SystemLog, SystemLogSearch> getBaseMapper() {
		return systemLogMapper;
	}

	
}
