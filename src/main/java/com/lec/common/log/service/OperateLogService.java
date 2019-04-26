package com.lec.common.log.service;

import java.util.Map;

import com.lec.common.log.vo.OperationLog;
import com.lec.framework.base.Page;

/***
 * 日志服务类
 * @author zhouhaij
 * @Apr 25, 2013 8:23:59 AM
 */
public interface OperateLogService {

	/***
	 * 保存日志
	 * @param log
	 */
	public void save(OperationLog log);
	
	
	/***
	 * 根据id获取操作日志
	 * @param id
	 * @return
	 */
    public OperationLog selectLogById(String id);
	
	/***
	 * 获取日志的分页列表数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getLogsByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);
	
}
