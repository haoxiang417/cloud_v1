package com.lec.core.service;

import com.lec.framework.base.Page;

import java.util.List;
import java.util.Map;

/**
 * 所有Service的父接口
 * @author zhouhaij
 * @2013-3-22 下午02:42:02
 */
public interface BaseService<T,S> {

    /***
     * 根据条件删除,可实现批量删除
     * @param example
     * @return
     */
    int deleteByExample(S example);
    
    /***
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /***
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteById(String id, T record);
    
    /***
     * 保存
     * @param record
     * @return
     */
    int save(T record);
    
    /***
	 * 根据实例获取记录条数
	 * @param example
	 * @return
	 */
    int getTotalByExample(S example);
    
    /***
     * 根据条件获取记录
     * @param example
     * @return
     */
    List<T> selectByExample(S example);
    
    /***
     * 根据条件获取分页数据
     * @param example
     * @param rowBounds
     * @return
     */
    Page selectByExample(S example, int pageNo, int pageSize);
    
    /***
     * 根据条件获取分页数据
     * 
     * @param map  key为映射类的属性
     * @param pageNo
     * @param pageSize
     * @param sortType
     * @return
     */
    Page getListByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);
    
    /***
     * 根据条件获取分页数据
     * @param map  key为映射类的属性
     * @param pageNo
     * @param pageSize
     * @param sortType
     * @param menuid 
     * @return
     */
    Page getListByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType, String menuid);

    
    /***
     * 分页总数方法与getListByCondition配套使用，以实现分页
     * @param map
     * @return
     */
    int countList(Map<String, Object> map);

    /***
     * 带权限的总数查询
     * @param map
     * @param menuid
     * @return
     */
    int countList(Map<String, Object> map, String menuid);
    
    /***
     * 根据主键获取对象
     * @param id
     * @return
     */
    T getById(String id);
    /***
     * 根据条件修改实例(部分属性会修改) 
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(T record, S example);
    /***
     * 根据条件修改实例(所有属性都会修改) 
     * @param record
     * @param example
     * @return
     */
    int updateByExample(T record, S example);
    /***
     * 根据主键修改实例(部分属性会修改) 
     * @param record
     * @param example
     * @return
     */ 
    int updateByIdSelective(T record);
    /***
     * 根据属性修改实例(所有属性都会修改) 
     * @param record
     * @param example
     * @return
     */
    int updateById(T record);
}
