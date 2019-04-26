package com.lec.common.system.dao;

import java.util.List;
import java.util.Map;

import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceHelp;

public interface SystemResourceHelpMapper {

	int save(SystemResourceHelp info);
	
	int update(SystemResourceHelp info);
	
	SystemResourceHelp getByMenuId(String menuId);
	
	List<SystemResource> getChileMenu(Map<String, Object> args);
	
}
