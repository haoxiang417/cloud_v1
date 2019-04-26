package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * 布控报警类型报表数据封装类
 * @author guikaiping
 */
public class BlackTypeReport implements Serializable{
	
	private static final long serialVersionUID = -3463723937557721045L;
	
	/***
	 * 设备编码
	 */
	private String deviceCode;
	/***
	 * 设备名称
	 */
	private String deviceName;

	/***
	 * 道路编码
	 */
	private String roadId;
	/***
	 * 方向编码
	 */
	private String directionCode;

	/***
	 * 总和
	 */
	private BigDecimal totals;
	
	/***以下为各违法类型的数据***/
	private String[] typeNames;
	//布控报警数
	private BigDecimal[] blackTypeCounts;
	
	//布控报警车辆总数
	private int counts;
	/***各违法类型数据结束***/
	
	
	/**
	 * @return the deviceCode
	 */
	public String getDeviceCode() {
		return deviceCode;
	}
	/**
	 * @param deviceCode the deviceCode to set
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	/**
	 * @return the roadName
	 */
	public String getRoadId() {
		return roadId;
	}
	/**
	 * @param roadName the roadName to set
	 */
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	/**
	 * @return the directionCode
	 */
	public String getDirectionCode() {
		return directionCode;
	}
	/**
	 * @param directionCode the directionCode to set
	 */
	public void setDirectionCode(String directionCode) {
		this.directionCode = directionCode;
	}
	
	/**
	 * @return the totals
	 */
	public BigDecimal getTotals() {
		return totals;
	}
	/**
	 * @param totals the totals to set
	 */
	public void setTotals(BigDecimal totals) {
		this.totals = totals;
	}
	/**
	 * @return the typeNames
	 */
	public String[] getTypeNames() {
		return typeNames;
	}
	/**
	 * @param typeNames the typeNames to set
	 */
	public void setTypeNames(String[] typeNames) {
		this.typeNames = typeNames;
	}

	public BigDecimal getResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < blackTypeCounts.length; i++) {
			result= result.add(blackTypeCounts[i]==null?new BigDecimal(0):blackTypeCounts[i]);
		}
		return result;
	}
	/**
	 * @return the blackTypeCounts
	 */
	public BigDecimal[] getBlackTypeCounts() {
		return blackTypeCounts;
	}
	/**
	 * @param blackTypeCounts the blackTypeCounts to set
	 */
	public void setBlackTypeCounts(BigDecimal[] blackTypeCounts) {
		this.blackTypeCounts = blackTypeCounts;
	}
	/**
	 * @return the counts
	 */
	public int getCounts() {
		return counts;
	}
	/**
	 * @param counts the counts to set
	 */
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	/**
	 * 重写equals方法，用于环比数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof BlackTypeReport) {
			BlackTypeReport blackTypeReport = (BlackTypeReport) obj;
			String roadId = blackTypeReport.getRoadId()==null?"":blackTypeReport.getRoadId();
			String directCode = blackTypeReport.getDirectionCode();
			return (roadId.equals(this.roadId) && directCode.equals(this.directionCode));
			
		}else{
			return false;
		}
			
	}
	
}
