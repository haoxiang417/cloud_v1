package com.lec.common.dictionary.dao;

import com.lec.common.dictionary.vo.Dic;
import com.lec.common.dictionary.vo.DicSearch;
import com.lec.framework.base.BaseMapper;
/***
 * 数据字典mapper
 * @author zhouhaij
 * @2013-3-22 下午03:33:20
 */
public interface DicMapper extends BaseMapper<Dic,DicSearch>{
	//获取最新的编码
	String selectMaxCode(String type);
}