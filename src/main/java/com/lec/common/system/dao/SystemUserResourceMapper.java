package com.lec.common.system.dao;

import java.util.List;

import com.lec.common.system.vo.SystemUserResource;

public interface SystemUserResourceMapper {

	int save(SystemUserResource info);
	
	int delete(String userId);
	
	List<String> getByUserId(String userId);
}
