package com.lec.common.system.service;

import java.util.List;

import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceHelp;

public interface SystemResourceHelpService {

	int save(SystemResourceHelp info);
	
	int update(SystemResourceHelp info);
	
	SystemResourceHelp getByMenuId(String menuId);
	
	List<SystemResource> getChileMenu(String menuId, String userId);
}
