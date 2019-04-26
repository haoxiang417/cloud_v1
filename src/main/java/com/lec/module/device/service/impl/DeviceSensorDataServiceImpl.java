package com.lec.module.device.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.module.device.dao.DeviceSensorDataMapper;
import com.lec.module.device.service.DeviceSensorDataService;
import com.lec.module.device.vo.DeviceSensorData;
import com.lec.module.device.vo.DeviceSensorDataSearch;

@Service
public class DeviceSensorDataServiceImpl extends AbstractBaseService<DeviceSensorData, DeviceSensorDataSearch> implements DeviceSensorDataService {
    @Resource
    private DeviceSensorDataMapper deviceSensorDataMapper;

    @Override
    public BaseMapper<DeviceSensorData, DeviceSensorDataSearch> getBaseMapper() {
         return deviceSensorDataMapper;
    }
}