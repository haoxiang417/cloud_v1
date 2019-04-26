package com.lec.module.device.service;

import com.lec.core.service.BaseService;
import com.lec.module.device.vo.DeviceSensor;
import com.lec.module.device.vo.DeviceSensorSearch;

public interface DeviceSensorService extends BaseService<DeviceSensor, DeviceSensorSearch> {
	
	
	/**
	 * 保存传感器信息
	 * @param deviceId
	 * @param sName
	 * @param sType
	 * @param sNum
	 * @param sUnit
	 */
	void saveInfos(String deviceId, String[] sName, String[] sType, String[] sNum, String[] sUnit, String[] sState, Double[] sRange, Double[] sMin, Double[] sMax);
	
	/**
	 * 修改传感器信息
	 * @param deviceId
	 * @param sName
	 * @param sType
	 * @param sNum
	 * @param sUnit
	 */
	void updateInfos(String deviceId, String[] sId, String[] sName, String[] sType, String[] sNum, String[] sUnit, String[] sState, Double[] sRange, Double[] sMin, Double[] sMax);
	
	/**
	 * 销毁（删除）传感器信息
	 * @param deviceId
	 */
	void deleteByDeviceId(String deviceId);
}