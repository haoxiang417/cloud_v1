package com.lec.common.system.service;

import java.util.Hashtable;
import java.util.Map;

import com.lec.common.system.vo.SystemParams;
import com.lec.common.system.vo.SystemParamsSearch;
import com.lec.core.service.BaseService;

/***
 * 系统参数
 * @author zhouhaij
 * @May 6, 2013 4:07:05 PM
 */
public interface ParamsService extends BaseService<SystemParams, SystemParamsSearch>{
	
	/***
	 * 系统参数map,供整个系统使用
	 */
	public Map<String,String> SYSTEM_PARAMS = new Hashtable<String, String>();
	
	/***
	 * 根据key值和type得到对应的对象
	 * @param key
	 * @param type
	 * @return
	 */
	public SystemParams getParamsByKeyAndType(String key, String type);
	
	/***
	 * 获取所有的参数
	 * @type 0表示用户参数   1表示系统参数
	 * @return
	 */
	public Map<String,String> getAllParams(String type);
}
