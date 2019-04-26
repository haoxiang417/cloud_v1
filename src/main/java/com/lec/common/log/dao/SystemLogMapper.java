package com.lec.common.log.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.lec.common.log.vo.SystemLog;
import com.lec.common.log.vo.SystemLogSearch;
import com.lec.framework.base.BaseMapper;
/***
 * 系统日志
 * @author zhouhaij
 * @Apr 25, 2013 8:43:48 AM
 */
public interface SystemLogMapper extends BaseMapper<SystemLog, SystemLogSearch>{

	/***
	 * 获取上一次登录的信息
	 * @param account
	 * @param logTime
	 * @return
	 */
	SystemLog selectLastLogUser(String account, String logTime);
	/***
	 * 获取日志的列表数据
	 * @param orgid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
    List<SystemLog> selectLogs(Map<String, Object> args, RowBounds rowBounds);
    
    
	/***
	 * 根据实例获取记录条数
	 * @param example
	 * @return
	 */
    int countLogs(Map<String, Object> args);
}