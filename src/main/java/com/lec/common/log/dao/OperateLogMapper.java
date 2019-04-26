package com.lec.common.log.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.lec.common.log.vo.OperationLog;

public interface OperateLogMapper {

	/***
	 * 保存日志
	 * @param log
	 */
	public void insert(OperationLog log);
	
	
	/***
	 * 获取日志的列表数据
	 * @param orgid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
    List<OperationLog> selectLogs(Map<String, Object> args, RowBounds rowBounds);
    
    
	/***
	 * 根据实例获取记录条数
	 * @param example
	 * @return
	 */
    int countByExample(Map<String, Object> args);
	
    public OperationLog selectLogById(String id);
}
