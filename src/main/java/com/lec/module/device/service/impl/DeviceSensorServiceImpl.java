package com.lec.module.device.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lec.core.service.AbstractBaseService;
import com.lec.framework.base.BaseMapper;
import com.lec.framework.util.UuidGenerateUtil;
import com.lec.module.device.dao.DeviceSensorMapper;
import com.lec.module.device.service.DeviceSensorService;
import com.lec.module.device.vo.DeviceSensor;
import com.lec.module.device.vo.DeviceSensorSearch;

@Service
public class DeviceSensorServiceImpl extends AbstractBaseService<DeviceSensor, DeviceSensorSearch> implements DeviceSensorService {
    @Resource
    private DeviceSensorMapper deviceSensorMapper;

    @Override
    public BaseMapper<DeviceSensor, DeviceSensorSearch> getBaseMapper() {
         return deviceSensorMapper;
    }

	@Override
	public void saveInfos(String deviceId, String[] sName, String[] sType, String[] sNum, String[] sUnit, String[] sState, Double[] sRange, Double[] sMin, Double[] sMax) {
		List<DeviceSensor> list = this.createVo(deviceId, sName, sType, sNum, sUnit, sState, sRange, sMin, sMax);
		for (DeviceSensor ds : list) {
			this.save(ds);
		}
	}

	private List<DeviceSensor> createVo(String deviceId, String[] sName, String[] sType, String[] sNum, String[] sUnit, String[] sState, Double[] sRange, Double[] sMin, Double[] sMax) {
		List<DeviceSensor> list = new ArrayList<DeviceSensor>();
		DeviceSensor ds;
		if (sName != null) {
			for (int i = 0; i < sName.length; i++) {
				ds = new DeviceSensor();
		        ds.setId(UuidGenerateUtil.getUUIDLong());
		        ds.setDeviceId(deviceId);
		        ds.setCode(i + 1 + "");
		        ds.setName(sName[i]);
		        ds.setType(sType[i]);
		        if ("1,2,3".indexOf(sType[i]) > -1) {
		          ds.setDecimalNum(sNum[i]);
		          ds.setUnit(sUnit[i]);
		        }
		        ds.setStatus(sState[i]);
		        ds.setRange(sRange[i] == null ? null : new BigDecimal(sRange[i].doubleValue()));
		        ds.setMeasureMin(sMin[i] == null ? null : new BigDecimal(sMin[i].doubleValue()));
		        ds.setMeasureMax(sMax[i] == null ? null : new BigDecimal(sMax[i].doubleValue()));
		        list.add(ds);
			}
		}
		return list;
	}

	@Override
	public void updateInfos(String deviceId, String[] sId, String[] sName, String[] sType, String[] sNum, String[] sUnit, String[] sState, Double[] sRange, Double[] sMin, Double[] sMax) {
		deleteByDeviceId(deviceId);
	    saveInfos(deviceId, sName, sType, sNum, sUnit, sState, sRange, sMin, sMax);
	}

	@Override
	public void deleteByDeviceId(String deviceId) {
		DeviceSensorSearch search = new DeviceSensorSearch();
		search.createCriteria().andDeviceIdEqualTo(deviceId);
		this.deleteByExample(search);
	}
}