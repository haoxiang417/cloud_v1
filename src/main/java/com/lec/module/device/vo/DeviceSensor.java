package com.lec.module.device.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceSensor {
    private String id;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 传感器编号
     */
    private String code;

    /**
     * 传感器名称
     */
    private String name;

    /**
     * 传感器类型
     */
    private String type;

    /**
     * 小数位
     */
    private String decimalNum;

    /**
     * 单位
     */
    private String unit;

    /**
     * 传感器图标
     */
    private String icon;

    /**
     * 状态；0=未启用，1=已启用
     */
    private String status;

    /**
     * 是否连接；0=未连接，1=已连接
     */
    private String connect;
    
    /**
     * 量程
     */
    private BigDecimal range;
    
    /**
     * 测量下限
     */
    private BigDecimal measureMin;
    
    /**
     * 测量上限
     */
    private BigDecimal measureMax;
    
    
    //查询关联属性
    private String deviceCode;
    private String deviceName;
    private Date dataTime;
    private String data;
    
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
     * @return the value of DEVICE_ID
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
    
     *
     * @param deviceId the value for DEVICE_ID
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
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
     * @return the value of DECIMAL_NUM
     */
    public String getDecimalNum() {
        return decimalNum;
    }

    /**
    
     *
     * @param decimalNum the value for DECIMAL_NUM
     */
    public void setDecimalNum(String decimalNum) {
        this.decimalNum = decimalNum == null ? null : decimalNum.trim();
    }

    /**
     * @return the value of UNIT
     */
    public String getUnit() {
        return unit;
    }

    /**
    
     *
     * @param unit the value for UNIT
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
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

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public BigDecimal getRange() {
		return range;
	}

	public void setRange(BigDecimal range) {
		this.range = range;
	}

	public BigDecimal getMeasureMin() {
		return measureMin;
	}

	public void setMeasureMin(BigDecimal measureMin) {
		this.measureMin = measureMin;
	}

	public BigDecimal getMeasureMax() {
		return measureMax;
	}

	public void setMeasureMax(BigDecimal measureMax) {
		this.measureMax = measureMax;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
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

}