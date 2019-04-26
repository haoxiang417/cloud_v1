package com.lec.module.device.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.module.device.dao.DeviceSensorTriggerMapper;
import com.lec.module.device.service.DeviceSensorTriggerService;
import com.lec.module.device.vo.DeviceSensorTrigger;
import com.lec.module.device.vo.DeviceSensorTriggerSearch;

@Service
public class DeviceSensorTriggerServiceImpl extends AbstractBaseService<DeviceSensorTrigger, DeviceSensorTriggerSearch> implements DeviceSensorTriggerService {
    @Resource
    private DeviceSensorTriggerMapper deviceSensorTriggerMapper;

    @Override
    public BaseMapper<DeviceSensorTrigger, DeviceSensorTriggerSearch> getBaseMapper() {
         return deviceSensorTriggerMapper;
    }
}