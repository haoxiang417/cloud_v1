package com.lec.module.device.service;

import com.lec.core.service.BaseService;
import com.lec.module.device.vo.DeviceInfo;
import com.lec.module.device.vo.DeviceInfoSearch;

public interface DeviceInfoService extends BaseService<DeviceInfo, DeviceInfoSearch> {
	
	void destroyById(String id);
}