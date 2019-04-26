package com.lec.common.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.common.system.dao.SystemResourceHelpMapper;
import com.lec.common.system.service.SystemResourceHelpService;
import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceHelp;

@Service
public class SystemResourceHelpServiceImpl implements SystemResourceHelpService {

	@Resource
	SystemResourceHelpMapper systemResourceHelpMapper;

	@Override
	public int save(SystemResourceHelp info) {
		return systemResourceHelpMapper.save(info);
	}

	@Override
	public int update(SystemResourceHelp info) {
		SystemResourceHelp temp = this.getByMenuId(info.getMenuId());
		if (temp == null) {
			return this.save(info);
		}
		return systemResourceHelpMapper.update(info);
	}

	@Override
	public SystemResourceHelp getByMenuId(String menuId) {
		return systemResourceHelpMapper.getByMenuId(menuId);
	}

	@Override
	public List<SystemResource> getChileMenu(String menuId, String userId) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("menuId", menuId);
		args.put("userId", userId);
		return systemResourceHelpMapper.getChileMenu(args);
	}
	
}
