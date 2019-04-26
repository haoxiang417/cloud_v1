package com.lec.module.device.vo;

public class DeviceSensorTrigger {
    private String id;

    /**
     * 设备传感器ID
     */
    private String sensorId;

    /**
     * 触发类型
     */
    private String type;

    /**
     * 触发值1
     */
    private String triggerVal1;

    /**
     * 触发值2
     */
    private String triggerVal2;

    /**
     * 是否转发
     */
    private String isForward;

    /**
     * 转发传感器ID
     */
    private String forwardSensorId;

    /**
     * 数据格式
     */
    private String dataFormat;

    /**
     * 转发数据
     */
    private String forwardData;

    /**
     * 状态；0=停用，1=启用
     */
    private String status;

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
     * @return the value of SENSOR_ID
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
    
     *
     * @param sensorId the value for SENSOR_ID
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId == null ? null : sensorId.trim();
    }

    /**
     * @return the value of TYPE
     */
    public String getType() {
        return type;
    }

    /**
    
     *
     * @param type the value for TYPE
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return the value of TRIGGER_VAL1
     */
    public String getTriggerVal1() {
        return triggerVal1;
    }

    /**
    
     *
     * @param triggerVal1 the value for TRIGGER_VAL1
     */
    public void setTriggerVal1(String triggerVal1) {
        this.triggerVal1 = triggerVal1 == null ? null : triggerVal1.trim();
    }

    /**
     * @return the value of TRIGGER_VAL2
     */
    public String getTriggerVal2() {
        return triggerVal2;
    }

    /**
    
     *
     * @param triggerVal2 the value for TRIGGER_VAL2
     */
    public void setTriggerVal2(String triggerVal2) {
        this.triggerVal2 = triggerVal2 == null ? null : triggerVal2.trim();
    }

    /**
     * @return the value of IS_FORWARD
     */
    public String getIsForward() {
        return isForward;
    }

    /**
    
     *
     * @param isForward the value for IS_FORWARD
     */
    public void setIsForward(String isForward) {
        this.isForward = isForward == null ? null : isForward.trim();
    }

    /**
     * @return the value of FORWARD_SENSOR_ID
     */
    public String getForwardSensorId() {
        return forwardSensorId;
    }

    /**
    
     *
     * @param forwardSensorId the value for FORWARD_SENSOR_ID
     */
    public void setForwardSensorId(String forwardSensorId) {
        this.forwardSensorId = forwardSensorId == null ? null : forwardSensorId.trim();
    }

    /**
     * @return the value of DATA_FORMAT
     */
    public String getDataFormat() {
        return dataFormat;
    }

    /**
    
     *
     * @param dataFormat the value for DATA_FORMAT
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat == null ? null : dataFormat.trim();
    }

    /**
     * @return the value of FORWARD_DATA
     */
    public String getForwardData() {
        return forwardData;
    }

    /**
    
     *
     * @param forwardData the value for FORWARD_DATA
     */
    public void setForwardData(String forwardData) {
        this.forwardData = forwardData == null ? null : forwardData.trim();
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
    
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sensorId=").append(sensorId);
        sb.append(", type=").append(type);
        sb.append(", triggerVal1=").append(triggerVal1);
        sb.append(", triggerVal2=").append(triggerVal2);
        sb.append(", isForward=").append(isForward);
        sb.append(", forwardSensorId=").append(forwardSensorId);
        sb.append(", dataFormat=").append(dataFormat);
        sb.append(", forwardData=").append(forwardData);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}