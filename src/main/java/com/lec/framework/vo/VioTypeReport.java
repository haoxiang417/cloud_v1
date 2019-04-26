package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * 违法报表数据封装类
 * @author guikaiping
 */
public class VioTypeReport implements Serializable{
	
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
	 * 道路名称
	 */
	private String roadId;
	/***
	 * 道路编号
	 */
	private String roadCode;
	/***
	 * 道路名称
	 */
	private String roadName;
	/***
	 * 方向编码
	 */
	private String directionCode;
	/***
	 * 车道编码
	 */
	private String laneCode;

	/***
	 * 总和
	 */
	private BigDecimal totals;
	
	/***以下为各违法类型的数据***/
	private BigDecimal[] types;
	private String[] typeNames;
	//已确认违法数
	private BigDecimal[] affirms;
	//未确认违法数
	private BigDecimal[] notaffirms;
	private String[] vioCounts;
	//add by kouyunhao 2013-12-26 添加违法数量二维数组，用于首页显示。
	private String[][] vioCounts2;
	//违法车次
	private BigDecimal[] countAll;
	
	//违法车辆总数
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
	 * @return the roadCode
	 */
	public String getRoadCode() {
		return roadCode;
	}


	/**
	 * @param roadCode the roadCode to set
	 */
	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}


	/**
	 * @return the roadName
	 */
	public String getRoadName() {
		return roadName;
	}


	/**
	 * @param roadName the roadName to set
	 */
	public void setRoadName(String roadName) {
		this.roadName = roadName;
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
	 * @return the laneCode
	 */
	public String getLaneCode() {
		return laneCode;
	}


	/**
	 * @param laneCode the laneCode to set
	 */
	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
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
	 * @return the vioCounts
	 */
	public String[] getVioCounts() {
		return vioCounts;
	}


	/**
	 * @param vioCounts the vioCounts to set
	 */
	public void setVioCounts(String[] vioCounts) {
		this.vioCounts = vioCounts;
	}

	
	/**
	 * @return the types
	 */
	public BigDecimal[] getTypes() {
		return types;
	}


	/**
	 * @param types the types to set
	 */
	public void setTypes(BigDecimal[] types) {
		this.types = types;
	}


	/**
	 * @return the roadId
	 */
	public String getRoadId() {
		return roadId;
	}


	/**
	 * @param roadId the roadId to set
	 */
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	

	public BigDecimal getResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < types.length; i++) {
			result= result.add(types[i]==null?new BigDecimal(0):types[i]);
		}
		return result;
	}

	public BigDecimal getCountAllResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < types.length; i++) {
			result= result.add(types[i]==null?new BigDecimal(0):types[i]);
		}
		return result;
	}

	/**
	 * @return the affirms
	 */
	public BigDecimal[] getAffirms() {
		return affirms;
	}


	/**
	 * @param affirms the affirms to set
	 */
	public void setAffirms(BigDecimal[] affirms) {
		this.affirms = affirms;
	}


	/**
	 * @return the notaffirms
	 */
	public BigDecimal[] getNotaffirms() {
		return notaffirms;
	}


	/**
	 * @param notaffirms the notaffirms to set
	 */
	public void setNotaffirms(BigDecimal[] notaffirms) {
		this.notaffirms = notaffirms;
	}


	public BigDecimal[] getCountAll() {
		return countAll;
	}


	public void setCountAll(BigDecimal[] countAll) {
		this.countAll = countAll;
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

	/**
	 * 重写equals方法，用于环比数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof VioTypeReport) {
			VioTypeReport vioTypeReport = (VioTypeReport) obj;
			String roadId = vioTypeReport.getRoadId()==null?"":vioTypeReport.getRoadId();
			String directCode = vioTypeReport.getDirectionCode();
			return (roadId.equals(this.roadId) && directCode.equals(this.directionCode));
			
		}else{
			return false;
		}
			
	}

	/**
	 * @return the vioCounts2
	 */
	public String[][] getVioCounts2() {
		return vioCounts2;
	}


	/**
	 * @param vioCounts2 the vioCounts2 to set
	 */
	public void setVioCounts2(String[][] vioCounts2) {
		this.vioCounts2 = vioCounts2;
	}
	
}
