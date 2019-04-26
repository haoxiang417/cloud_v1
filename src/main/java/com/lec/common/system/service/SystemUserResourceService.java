package com.lec.common.system.service;

import java.util.List;

public interface SystemUserResourceService {

	int save(String userId, String[] resourceIds);
	
	List<String> getList(String userId);
	
}
