package com.lec.module.device.vo;

import java.util.Date;

public class DeviceSensorData {
	private String id;

	/**
	 * 设备编号
	 */
	private String deviceCode;
	
	/**
	 * 数据时间
	 */
	private Date dataTime;
	
	/**
	 * 数据值
	 */
	private String data;

	/**
	 * 传感器CODE
	 */
	private String sensorCode;

	/**
	 * 传输类型
	 */
	private String sendType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSensorCode() {
		return sensorCode;
	}

	public void setSensorCode(String sensorCode) {
		this.sensorCode = sensorCode;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

}