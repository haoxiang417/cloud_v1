package com.lec.module.device.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceInfo {
    private String id;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接协议
     */
    private String agreement;

    /**
     * 上报周期类型
     */
    private String cycleType;

    /**
     * 上报周期
     */
    private String cycle;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 设备图标
     */
    private String icon;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 串口号
     */
    private String serialNo;
    
    /**
     * 视频URL
     */
    private String videoUrl;

    /**
     * 是否公开
     */
    private String isOpen;

    /**
     * 状态；0=未连接，1=已连接，2=已禁用，9=已删除
     */
    private String status;

    /**
     * 创建人
     */
    private String createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * @return the value of ID
     */
    public String getId() {
        return id;
    }

    /**
    
     *
     * @param id the value for ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return the value of CODE
     */
    public String getCode() {
        return code;
    }

    /**
    
     *
     * @param code the value for CODE
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return the value of NAME
     */
    public String getName() {
        return name;
    }

    /**
    
     *
     * @param name the value for NAME
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of AGREEMENT
     */
    public String getAgreement() {
        return agreement;
    }

    /**
    
     *
     * @param agreement the value for AGREEMENT
     */
    public void setAgreement(String agreement) {
        this.agreement = agreement == null ? null : agreement.trim();
    }

    /**
     * @return the value of CYCLE_TYPE
     */
    public String getCycleType() {
        return cycleType;
    }

    /**
    
     *
     * @param cycleType the value for CYCLE_TYPE
     */
    public void setCycleType(String cycleType) {
        this.cycleType = cycleType == null ? null : cycleType.trim();
    }

    /**
     * @return the value of CYCLE
     */
    public String getCycle() {
        return cycle;
    }

    /**
    
     *
     * @param cycle the value for CYCLE
     */
    public void setCycle(String cycle) {
        this.cycle = cycle == null ? null : cycle.trim();
    }

    /**
     * @return the value of LONGITUDE
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
    
     *
     * @param longitude the value for LONGITUDE
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the value of LATITUDE
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
    
     *
     * @param latitude the value for LATITUDE
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the value of ICON
     */
    public String getIcon() {
        return icon;
    }

    /**
    
     *
     * @param icon the value for ICON
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * @return the value of IP
     */
    public String getIp() {
        return ip;
    }

    /**
    
     *
     * @param ip the value for IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * @return the value of PORT
     */
    public Integer getPort() {
        return port;
    }

    /**
    
     *
     * @param port the value for PORT
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * @return the value of SERIAL_NO
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
    
     *
     * @param serialNo the value for SERIAL_NO
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
     * @return the value of IS_OPEN
     */
    public String getIsOpen() {
        return isOpen;
    }

    /**
    
     *
     * @param isOpen the value for IS_OPEN
     */
    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }

    /**
     * @return the value of STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
    
     *
     * @param status the value for STATUS
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return the value of CREATE_ID
     */
    public String getCreateId() {
        return createId;
    }

    /**
    
     *
     * @param createId the value for CREATE_ID
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * @return the value of CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
    
     *
     * @param createTime the value for CREATE_TIME
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of UPDATE_ID
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
    
     *
     * @param updateId the value for UPDATE_ID
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * @return the value of UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
    
     *
     * @param updateTime the value for UPDATE_TIME
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
    
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", agreement=").append(agreement);
        sb.append(", cycleType=").append(cycleType);
        sb.append(", cycle=").append(cycle);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", icon=").append(icon);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", isOpen=").append(isOpen);
        sb.append(", status=").append(status);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}