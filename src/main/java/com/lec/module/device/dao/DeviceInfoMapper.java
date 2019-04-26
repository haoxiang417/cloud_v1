package com.lec.module.device.dao;

import com.lec.framework.base.BaseMapper;
import com.lec.module.device.vo.DeviceInfo;
import com.lec.module.device.vo.DeviceInfoSearch;

public interface DeviceInfoMapper extends BaseMapper<DeviceInfo, DeviceInfoSearch> {
	
	void destroyById(String id);
}