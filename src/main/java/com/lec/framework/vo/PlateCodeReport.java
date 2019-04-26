package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * 区域号牌流量统计报表数据封装类
 * @author guikaiping
 */
public class PlateCodeReport implements Serializable{
	
	private static final long serialVersionUID = -3463723937557721045L;
	
	/***
	 * 设备编码
	 */
	private String deviceCode;
	
	/**
	 * 厂家ID
	 */
	private String companyId;
	
	/**
	 * 厂家名称
	 */
	private String companyName;
	
	/***
	 * 设备名称
	 */
	private String deviceName;

	/***
	 * 道路编码
	 */
	private String roadId;
	
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
	 * 其他数据的值
	 */
	private BigDecimal params;
	

	/***
	 * 总和
	 */
	private BigDecimal totals;
	private int roadtotals;
	
	/***以下为各区域号牌的数据***/
	private String[] plateNames;
	//区域号牌
	private BigDecimal[] plateCodesCounts;
	
	//道路方向
	private int[] dirctCodesCounts;
	
	private BigDecimal[] firstCodesCounts;
	private BigDecimal[] secondCodesCounts;
	private BigDecimal[] thirdCodesCounts;
	private BigDecimal[] fourthCodesCounts;
	private BigDecimal[] fifthCodesCounts;
	private BigDecimal[] sixthCodesCounts;
	private BigDecimal[] seventhCodesCounts;
	private BigDecimal[] eighthCodesCounts;
	private BigDecimal[] ninthCodesCounts;
	private BigDecimal[] tenthCodesCounts;
	
	//高峰流量速度
	private String[] firstCodesSpeed;
	private String[] secondCodesSpeed;
	private String[] thirdCodesSpeed;
	private String[] fourthCodesSpeed;
	private String[] fifthCodesSpeed;
	
	//区域号牌车辆总数
	private int counts;
	/***各区域号牌数据结束***/
	
	//区域号牌车流量
	private int firstCounts;
	private int secondCounts;
	private int thirdCounts;
	private int fourthCounts;
	private int fifthCounts;
	private int sixthCounts;
	private int seventhCounts;
	private int eighthCounts;
	private int ninthCounts;
	private int tenthCounts;
	
	//高峰流量速度
	private String firstSpeed;
	private String secondSpeed;
	private String thirdSpeed;
	private String fourthSpeed;
	private String fifthSpeed;
	
	//区域车牌号
	String firstName;
	String secondName;
	String thirdName;
	String fourthName;
	String fifthName;
	String sixthName;
	String seventhName;
	String eighthName;
	String ninthName;
	String tenthName;
	
	private String viewId;//前台道路标识符ID
	
	private String dataXml;//封装前台要显示的数据集合
	
	/**
	 * 重写equals方法，用于柱状数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof PlateCodeReport) {
			PlateCodeReport plateCodeReport = (PlateCodeReport) obj;
			String roadId = plateCodeReport.getRoadId()==null?"":plateCodeReport.getRoadId();
			String directCode = plateCodeReport.getDirectionCode();
			return (roadId.equals(this.roadId) && directCode.equals(this.directionCode));
			
		}else{
			return false;
		}
			
	}

	public BigDecimal getResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < plateCodesCounts.length; i++) {
			result= result.add(plateCodesCounts[i]==null?new BigDecimal(0):plateCodesCounts[i]);
		}
		return result;
	}
	
	public int getRoadResultTotals(){
		int result = 0;
		for (int i = 0; i < dirctCodesCounts.length; i++) {
			result += dirctCodesCounts[i];
		}
		return result;
	}

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
	 * @return the params
	 */
	public BigDecimal getParams() {
		return params;
	}



	/**
	 * @param params the params to set
	 */
	public void setParams(BigDecimal params) {
		this.params = params;
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
	 * @return the plateNames
	 */
	public String[] getPlateNames() {
		return plateNames;
	}



	/**
	 * @param plateNames the plateNames to set
	 */
	public void setPlateNames(String[] plateNames) {
		this.plateNames = plateNames;
	}



	/**
	 * @return the plateCodesCounts
	 */
	public BigDecimal[] getPlateCodesCounts() {
		return plateCodesCounts;
	}



	/**
	 * @param plateCodesCounts the plateCodesCounts to set
	 */
	public void setPlateCodesCounts(BigDecimal[] plateCodesCounts) {
		this.plateCodesCounts = plateCodesCounts;
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
	 * @return the firstCounts
	 */
	public int getFirstCounts() {
		return firstCounts;
	}

	/**
	 * @param firstCounts the firstCounts to set
	 */
	public void setFirstCounts(int firstCounts) {
		this.firstCounts = firstCounts;
	}

	/**
	 * @return the secondCounts
	 */
	public int getSecondCounts() {
		return secondCounts;
	}

	/**
	 * @param secondCounts the secondCounts to set
	 */
	public void setSecondCounts(int secondCounts) {
		this.secondCounts = secondCounts;
	}

	/**
	 * @return the thirdCounts
	 */
	public int getThirdCounts() {
		return thirdCounts;
	}

	/**
	 * @param thirdCounts the thirdCounts to set
	 */
	public void setThirdCounts(int thirdCounts) {
		this.thirdCounts = thirdCounts;
	}

	/**
	 * @return the fourthCounts
	 */
	public int getFourthCounts() {
		return fourthCounts;
	}

	/**
	 * @param fourthCounts the fourthCounts to set
	 */
	public void setFourthCounts(int fourthCounts) {
		this.fourthCounts = fourthCounts;
	}

	/**
	 * @return the fifthCounts
	 */
	public int getFifthCounts() {
		return fifthCounts;
	}

	/**
	 * @param fifthCounts the fifthCounts to set
	 */
	public void setFifthCounts(int fifthCounts) {
		this.fifthCounts = fifthCounts;
	}

	/**
	 * @return the sixthCounts
	 */
	public int getSixthCounts() {
		return sixthCounts;
	}

	/**
	 * @param sixthCounts the sixthCounts to set
	 */
	public void setSixthCounts(int sixthCounts) {
		this.sixthCounts = sixthCounts;
	}

	/**
	 * @return the seventhCounts
	 */
	public int getSeventhCounts() {
		return seventhCounts;
	}

	/**
	 * @param seventhCounts the seventhCounts to set
	 */
	public void setSeventhCounts(int seventhCounts) {
		this.seventhCounts = seventhCounts;
	}

	/**
	 * @return the eighthCounts
	 */
	public int getEighthCounts() {
		return eighthCounts;
	}

	/**
	 * @param eighthCounts the eighthCounts to set
	 */
	public void setEighthCounts(int eighthCounts) {
		this.eighthCounts = eighthCounts;
	}

	/**
	 * @return the ninthCounts
	 */
	public int getNinthCounts() {
		return ninthCounts;
	}

	/**
	 * @param ninthCounts the ninthCounts to set
	 */
	public void setNinthCounts(int ninthCounts) {
		this.ninthCounts = ninthCounts;
	}

	/**
	 * @return the tenthCounts
	 */
	public int getTenthCounts() {
		return tenthCounts;
	}

	/**
	 * @param tenthCounts the tenthCounts to set
	 */
	public void setTenthCounts(int tenthCounts) {
		this.tenthCounts = tenthCounts;
	}

	/**
	 * @return the firstCodesCounts
	 */
	public BigDecimal[] getFirstCodesCounts() {
		return firstCodesCounts;
	}

	/**
	 * @param firstCodesCounts the firstCodesCounts to set
	 */
	public void setFirstCodesCounts(BigDecimal[] firstCodesCounts) {
		this.firstCodesCounts = firstCodesCounts;
	}

	/**
	 * @return the secondCodesCounts
	 */
	public BigDecimal[] getSecondCodesCounts() {
		return secondCodesCounts;
	}

	/**
	 * @param secondCodesCounts the secondCodesCounts to set
	 */
	public void setSecondCodesCounts(BigDecimal[] secondCodesCounts) {
		this.secondCodesCounts = secondCodesCounts;
	}

	/**
	 * @return the thirdCodesCounts
	 */
	public BigDecimal[] getThirdCodesCounts() {
		return thirdCodesCounts;
	}

	/**
	 * @param thirdCodesCounts the thirdCodesCounts to set
	 */
	public void setThirdCodesCounts(BigDecimal[] thirdCodesCounts) {
		this.thirdCodesCounts = thirdCodesCounts;
	}

	/**
	 * @return the fourthCodesCounts
	 */
	public BigDecimal[] getFourthCodesCounts() {
		return fourthCodesCounts;
	}

	/**
	 * @param fourthCodesCounts the fourthCodesCounts to set
	 */
	public void setFourthCodesCounts(BigDecimal[] fourthCodesCounts) {
		this.fourthCodesCounts = fourthCodesCounts;
	}

	/**
	 * @return the fifthCodesCounts
	 */
	public BigDecimal[] getFifthCodesCounts() {
		return fifthCodesCounts;
	}

	/**
	 * @param fifthCodesCounts the fifthCodesCounts to set
	 */
	public void setFifthCodesCounts(BigDecimal[] fifthCodesCounts) {
		this.fifthCodesCounts = fifthCodesCounts;
	}

	/**
	 * @return the sixthCodesCounts
	 */
	public BigDecimal[] getSixthCodesCounts() {
		return sixthCodesCounts;
	}

	/**
	 * @param sixthCodesCounts the sixthCodesCounts to set
	 */
	public void setSixthCodesCounts(BigDecimal[] sixthCodesCounts) {
		this.sixthCodesCounts = sixthCodesCounts;
	}

	/**
	 * @return the seventhCodesCounts
	 */
	public BigDecimal[] getSeventhCodesCounts() {
		return seventhCodesCounts;
	}

	/**
	 * @param seventhCodesCounts the seventhCodesCounts to set
	 */
	public void setSeventhCodesCounts(BigDecimal[] seventhCodesCounts) {
		this.seventhCodesCounts = seventhCodesCounts;
	}

	/**
	 * @return the eighthCodesCounts
	 */
	public BigDecimal[] getEighthCodesCounts() {
		return eighthCodesCounts;
	}

	/**
	 * @param eighthCodesCounts the eighthCodesCounts to set
	 */
	public void setEighthCodesCounts(BigDecimal[] eighthCodesCounts) {
		this.eighthCodesCounts = eighthCodesCounts;
	}

	/**
	 * @return the ninthCodesCounts
	 */
	public BigDecimal[] getNinthCodesCounts() {
		return ninthCodesCounts;
	}

	/**
	 * @param ninthCodesCounts the ninthCodesCounts to set
	 */
	public void setNinthCodesCounts(BigDecimal[] ninthCodesCounts) {
		this.ninthCodesCounts = ninthCodesCounts;
	}

	/**
	 * @return the tenthCodesCounts
	 */
	public BigDecimal[] getTenthCodesCounts() {
		return tenthCodesCounts;
	}

	/**
	 * @param tenthCodesCounts the tenthCodesCounts to set
	 */
	public void setTenthCodesCounts(BigDecimal[] tenthCodesCounts) {
		this.tenthCodesCounts = tenthCodesCounts;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the thirdName
	 */
	public String getThirdName() {
		return thirdName;
	}

	/**
	 * @param thirdName the thirdName to set
	 */
	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	/**
	 * @return the fourthName
	 */
	public String getFourthName() {
		return fourthName;
	}

	/**
	 * @param fourthName the fourthName to set
	 */
	public void setFourthName(String fourthName) {
		this.fourthName = fourthName;
	}

	/**
	 * @return the fifthName
	 */
	public String getFifthName() {
		return fifthName;
	}

	/**
	 * @param fifthName the fifthName to set
	 */
	public void setFifthName(String fifthName) {
		this.fifthName = fifthName;
	}

	/**
	 * @return the sixthName
	 */
	public String getSixthName() {
		return sixthName;
	}

	/**
	 * @param sixthName the sixthName to set
	 */
	public void setSixthName(String sixthName) {
		this.sixthName = sixthName;
	}

	/**
	 * @return the seventhName
	 */
	public String getSeventhName() {
		return seventhName;
	}

	/**
	 * @param seventhName the seventhName to set
	 */
	public void setSeventhName(String seventhName) {
		this.seventhName = seventhName;
	}

	/**
	 * @return the eighthName
	 */
	public String getEighthName() {
		return eighthName;
	}

	/**
	 * @param eighthName the eighthName to set
	 */
	public void setEighthName(String eighthName) {
		this.eighthName = eighthName;
	}

	/**
	 * @return the ninthName
	 */
	public String getNinthName() {
		return ninthName;
	}

	/**
	 * @param ninthName the ninthName to set
	 */
	public void setNinthName(String ninthName) {
		this.ninthName = ninthName;
	}

	/**
	 * @return the tenthName
	 */
	public String getTenthName() {
		return tenthName;
	}

	/**
	 * @param tenthName the tenthName to set
	 */
	public void setTenthName(String tenthName) {
		this.tenthName = tenthName;
	}

	/**
	 * @return the dirctCodesCounts
	 */
	public int[] getDirctCodesCounts() {
		return dirctCodesCounts;
	}

	/**
	 * @param dirctCodesCounts the dirctCodesCounts to set
	 */
	public void setDirctCodesCounts(int[] dirctCodesCounts) {
		this.dirctCodesCounts = dirctCodesCounts;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the roadtotals
	 */
	public int getRoadtotals() {
		return roadtotals;
	}

	/**
	 * @param roadtotals the roadtotals to set
	 */
	public void setRoadtotals(int roadtotals) {
		this.roadtotals = roadtotals;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * @return the firstSpeed
	 */
	public String getFirstSpeed() {
		return firstSpeed;
	}

	/**
	 * @param firstSpeed the firstSpeed to set
	 */
	public void setFirstSpeed(String firstSpeed) {
		this.firstSpeed = firstSpeed;
	}

	/**
	 * @return the secondSpeed
	 */
	public String getSecondSpeed() {
		return secondSpeed;
	}

	/**
	 * @param secondSpeed the secondSpeed to set
	 */
	public void setSecondSpeed(String secondSpeed) {
		this.secondSpeed = secondSpeed;
	}

	/**
	 * @return the thirdSpeed
	 */
	public String getThirdSpeed() {
		return thirdSpeed;
	}

	/**
	 * @param thirdSpeed the thirdSpeed to set
	 */
	public void setThirdSpeed(String thirdSpeed) {
		this.thirdSpeed = thirdSpeed;
	}

	/**
	 * @return the fourthSpeed
	 */
	public String getFourthSpeed() {
		return fourthSpeed;
	}

	/**
	 * @param fourthSpeed the fourthSpeed to set
	 */
	public void setFourthSpeed(String fourthSpeed) {
		this.fourthSpeed = fourthSpeed;
	}

	/**
	 * @return the fifthSpeed
	 */
	public String getFifthSpeed() {
		return fifthSpeed;
	}

	/**
	 * @param fifthSpeed the fifthSpeed to set
	 */
	public void setFifthSpeed(String fifthSpeed) {
		this.fifthSpeed = fifthSpeed;
	}

	/**
	 * @return the firstCodesSpeed
	 */
	public String[] getFirstCodesSpeed() {
		return firstCodesSpeed;
	}

	/**
	 * @param firstCodesSpeed the firstCodesSpeed to set
	 */
	public void setFirstCodesSpeed(String[] firstCodesSpeed) {
		this.firstCodesSpeed = firstCodesSpeed;
	}

	/**
	 * @return the secondCodesSpeed
	 */
	public String[] getSecondCodesSpeed() {
		return secondCodesSpeed;
	}

	/**
	 * @param secondCodesSpeed the secondCodesSpeed to set
	 */
	public void setSecondCodesSpeed(String[] secondCodesSpeed) {
		this.secondCodesSpeed = secondCodesSpeed;
	}

	/**
	 * @return the thirdCodesSpeed
	 */
	public String[] getThirdCodesSpeed() {
		return thirdCodesSpeed;
	}

	/**
	 * @param thirdCodesSpeed the thirdCodesSpeed to set
	 */
	public void setThirdCodesSpeed(String[] thirdCodesSpeed) {
		this.thirdCodesSpeed = thirdCodesSpeed;
	}

	/**
	 * @return the fourthCodesSpeed
	 */
	public String[] getFourthCodesSpeed() {
		return fourthCodesSpeed;
	}

	/**
	 * @param fourthCodesSpeed the fourthCodesSpeed to set
	 */
	public void setFourthCodesSpeed(String[] fourthCodesSpeed) {
		this.fourthCodesSpeed = fourthCodesSpeed;
	}

	/**
	 * @return the fifthCodesSpeed
	 */
	public String[] getFifthCodesSpeed() {
		return fifthCodesSpeed;
	}

	/**
	 * @param fifthCodesSpeed the fifthCodesSpeed to set
	 */
	public void setFifthCodesSpeed(String[] fifthCodesSpeed) {
		this.fifthCodesSpeed = fifthCodesSpeed;
	}

	/**
	 * @return the viewId
	 */
	public String getViewId() {
		return viewId;
	}

	/**
	 * @param viewId the viewId to set
	 */
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	/**
	 * @return the dataXml
	 */
	public String getDataXml() {
		return dataXml;
	}

	/**
	 * @param dataXml the dataXml to set
	 */
	public void setDataXml(String dataXml) {
		this.dataXml = dataXml;
	}
	
	
}
