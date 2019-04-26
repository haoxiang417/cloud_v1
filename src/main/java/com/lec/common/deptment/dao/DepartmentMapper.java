package com.lec.common.deptment.dao;

import java.util.List;

import com.lec.common.deptment.vo.Department;
import com.lec.common.deptment.vo.DepartmentSearch;
import com.lec.framework.base.BaseMapper;
/***
 * 组织机构mapper
 * @author zhouhaij
 * @Apr 23, 2013 8:20:51 AM
 */
public interface DepartmentMapper extends BaseMapper<Department,DepartmentSearch>{

	/***
	 * 根据id获取所有的子节点
	 * @param id
	 * @return
	 */
	public List<Department> getLeafNodeById(String id);
	
	/***
	 * 判断是否有子节点
	 * @param id
	 * @return
	 */
	public int hasChild(String id);
	
	/***
	 * 获取树层级的节点个数
	 * @param level
	 * @return
	 */
	public int getCountByLevel(int level);
	
}