package com.lec.module.device.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.module.device.dao.DeviceInfoMapper;
import com.lec.module.device.service.DeviceInfoService;
import com.lec.module.device.vo.DeviceInfo;
import com.lec.module.device.vo.DeviceInfoSearch;

@Service
public class DeviceInfoServiceImpl extends AbstractBaseService<DeviceInfo, DeviceInfoSearch> implements DeviceInfoService {
    @Resource
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public BaseMapper<DeviceInfo, DeviceInfoSearch> getBaseMapper() {
         return deviceInfoMapper;
    }

	@Override
	public void destroyById(String id) {
		//调用销毁数据存储过程
		deviceInfoMapper.destroyById(id);
	}

}