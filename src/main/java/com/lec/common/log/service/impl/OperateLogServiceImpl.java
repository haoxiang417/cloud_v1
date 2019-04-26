package com.lec.common.log.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.common.log.dao.OperateLogMapper;
import com.lec.common.log.service.OperateLogService;
import com.lec.common.log.vo.OperationLog;
import com.lec.framework.base.Page;

/**
 * *
 * 日志服务类
 *
 * @author zhouhaij
 * @Apr 25, 2013 8:23:59 AM
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    OperateLogMapper operateLogMapper;

    /**
     * *
     * 保存日志
     *
     * @param log
     */
    @Override
    public void save(OperationLog log) {
        operateLogMapper.insert(log);
    }

    /**
     * *
     * 获取日志的分页列表数据
     *
     * @param pageNo
     * @param pageSize
     * @return
     * @throws  
     */
    @Override
    public Page getLogsByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType)   {
    	Map<String, Object> args = new HashMap<String, Object>();
    	args.putAll(map);
    	
    	if (args.containsKey("startDate") && args.containsKey("endDate") 
    			&& args.get("startDate").equals(args.get("endDate"))) {
    		args.put("startDate", args.get("startDate") + " 00:00:00");
    		args.put("endDate", args.get("endDate") + " 23:59:59");
    	}
        List<OperationLog> results = operateLogMapper.selectLogs(args, Page.getRowBounds(pageNo, pageSize));
        int totalCount = operateLogMapper.countByExample(args);
        return Page.getPage(totalCount, results, pageNo, pageSize);
    }

    /**
     * *
     * 根据id获取操作日志
     *
     * @param id
     * @return
     */
    @Override
    public OperationLog selectLogById(String id) {
        return operateLogMapper.selectLogById(id);
    }
}
