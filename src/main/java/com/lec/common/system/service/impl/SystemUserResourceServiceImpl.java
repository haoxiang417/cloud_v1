package com.lec.common.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.common.system.dao.SystemUserResourceMapper;
import com.lec.common.system.service.SystemUserResourceService;
import com.lec.common.system.vo.SystemUserResource;

@Service
public class SystemUserResourceServiceImpl implements SystemUserResourceService {

	@Resource
	SystemUserResourceMapper systemUserResourceMapper;

	@Override
	public int save(String userId, String[] resourceIds) {
		systemUserResourceMapper.delete(userId);
		int num = 1;
		for (String rid : resourceIds) {
			systemUserResourceMapper.save(new SystemUserResource(userId, rid, num++));
		}
		return 1;
	}

	@Override
	public List<String> getList(String userId) {
		return systemUserResourceMapper.getByUserId(userId);
	}
	
}
