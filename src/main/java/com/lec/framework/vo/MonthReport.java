package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/***
 * 周报表数据封装类
 * @author zhouhaij
 */
public class MonthReport implements Serializable{
	
	private static final long serialVersionUID = -3463723937557721045L;
	
	/***
	 * 设备编码
	 */
	private String deviceCode;
	/***
	 * 道路名称
	 */
	private String roadId;
	/***
	 * 部门CODE
	 */
	private String roadOrg;
	
	/***
	 * 道路等级 编码
	 */
	private String roadType;
	
	/***
	 * 道路等级
	 */
	private String roadTypeName;
	
	/**
	 * 施工单位ID
	 */
	private String builderId;
	/**
	 * 施工单位名称
	 */
	private String builderName;
	/***
	 * 方向编码
	 */
	private String directCode;
	/***
	 * 车道编码
	 */
	private String laneCode;
	
	/**
	 * 部门ID
	 */
	private String orgId;
	/**
	 * 设备类型
	 */
	private String carType;
	/**
	 * 设备名称
	 */
	private String name;
	/**
	 * GPRS号
	 */
	private String telnumber;
	
	
	/***
	 * 布控类型编号
	 */
	private String blackTypeCode;
	/**
	 * 平均值
	 */
	private BigDecimal avgValues;
	
	/***
	 * 其他数据的值
	 */
	private BigDecimal params;
	/***
	 * 设备名称
	 */
	private String deviceName;
	/***
	 * 一月的总和
	 */
	private BigDecimal totals;
	private BigDecimal ctotals;
	private BigDecimal ototals;
	private BigDecimal htotals;
	
	private BigDecimal resultTotals1;
	
	private int flowNumber = 0; //车辆数
	private BigDecimal speedNumber; //平均速度
	private String dayTime; //天日期

	private String viewId;//前台道路标识符ID
	
	private String dataXml;//封装前台要显示的数据集合
	
	//车辆总数
	private int counts;
	//外地车辆数
	private int nolocalCounts;
	//未识别车辆数
	private int notknownCounts;
	//本地车辆数
	private int localCounts;
	
	//蓝牌车辆数
	private int blueCounts;
	//黄牌车辆数
	private int yellowCounts;
	//其他牌车辆数
	private int otherCounts;
	//高峰流量
	private int firstCounts;
	private int secondCounts;
	private int thirdCounts;
	private int fourthCounts;
	private int fifthCounts;
	
	//高峰时段名称
	String firstName;
	String secondName;
	String thirdName;
	String fourthName;
	String fifthName;
	
	private int noLocalNumber = 0; //外地车辆数
	private int blackAlarmNumber = 0; //布控报警个数
	/***
	 * 外地车辆百分比
	 */
	private double precent;
	
	private int num;
	
	/***
	 * 一周的总和 平均速度
	 */
	private String avgSpeedTotals;
	private String havgSpeedTotals;
	
	/***以下为各天小时的数据***/
	private BigDecimal[] days;
	private BigDecimal[] days1;
	private BigDecimal[] days3;
	
	private BigDecimal[] daysT;
	private BigDecimal[] daysTa;
	private BigDecimal[] daysTs;
	private BigDecimal[] fastigiums;
	
	private double[] days2;
	private String[] dayPrecents;
	//add by 2013-12-27 添加外地车统计二维数组。
	private String[][] dayPrecents2;
	
	//add by 2014-03-07 添加流量统计二维数组。
	private String[][] dayFlows;
	
	private String[] percents;
	//按时间段统计挖占 数据
	private String[] daysOccupy;
	//add by 2013-12-26 添加违法数量二维数组。
	private String[][] daysOccupy2;
	//延期量集合
	private BigDecimal[] delayValue;
	//正常完成量集合
	private BigDecimal[] finishValue;
	
	/***各天数据结束***/
	
	//延期量
	private BigDecimal delayCount;
	//正常完成量
	private BigDecimal finishCount;
	
	//判断是否存在数据
	String flag;
	
	//路段名称
	private String roadName;
	//路段起点
	private String nodenameStart;
	//路段终点
	private String nodenameEnd;

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
	 * @return the directCode
	 */
	public String getDirectCode() {
		return directCode;
	}

	/**
	 * @param directCode the directCode to set
	 */
	public void setDirectCode(String directCode) {
		this.directCode = directCode;
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
	 * @return the avgValues
	 */
	public BigDecimal getAvgValues() {
		return avgValues;
	}

	/**
	 * @param avgValues the avgValues to set
	 */
	public void setAvgValues(BigDecimal avgValues) {
		this.avgValues = avgValues;
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
	 * @return the days
	 */
	public BigDecimal[] getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(BigDecimal[] days) {
		this.days = days;
	}
	
	
	/**
	 * @return the dayPrecents
	 */
	public String[] getDayPrecents() {
		return dayPrecents;
	}

	/**
	 * @param dayPrecents the dayPrecents to set
	 */
	public void setDayPrecents(String[] dayPrecents) {
		this.dayPrecents = dayPrecents;
	}
	
	/**
	 * @return the percents
	 */
	public String[] getPercents() {
		return percents;
	}

	/**
	 * @param percents the percents to set
	 */
	public void setPercents(String[] percents) {
		this.percents = percents;
	}

	public BigDecimal getResultTotals(){
		BigDecimal result = new BigDecimal(0);
		if (null != days) {
			for (int i = 0; i < days.length; i++) {
				result= result.add(days[i]==null?new BigDecimal(0):days[i]);
			}
		} else {
			result = null;
		}
		
		return result;
	}
	
	public BigDecimal getHResultTotals(){
		BigDecimal result = new BigDecimal(0);
		if (null != days1) {
			for (int i = 0; i < days1.length; i++) {
				result= result.add(days1[i]==null?new BigDecimal(0):days1[i]);
			}
		} else {
			result = null;
		}
		
		return result;
	}
	/**
	 * 时段流量 总数
	 * @return
	 */
	public BigDecimal getTResultTotals(){
		BigDecimal result = new BigDecimal(0);
		if (null != daysT) {
			for (int i = 0; i < daysT.length; i++) {
				result= result.add(daysT[i]==null?new BigDecimal(0):daysT[i]);
			}
		} else {
			result = null;
		}
		
		return result;
	}
	
	/**
	 * 时段流量 平均数
	 * @return
	 */
	public BigDecimal getTAResultTotals(){
		BigDecimal m = new BigDecimal(daysTa.length);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < daysTa.length; i++) {
			result= result.add(daysTa[i]==null?new BigDecimal(0):daysTa[i]);
		}
		return result.divide(m, mc);
	}
	
	/**
	 * 时段流量 速度
	 * @return
	 */
	public BigDecimal getTSResultTotals(){
		BigDecimal m = new BigDecimal(daysTs.length);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < daysTs.length; i++) {
			result= result.add(daysTs[i]==null?new BigDecimal(0):daysTs[i]);
		}
		return result.divide(m, mc);
	}
	
	
	public BigDecimal getOResultTotals(){
		BigDecimal result = new BigDecimal(0);
		if (null != days3) {
			for (int i = 0; i < days3.length; i++) {
				result= result.add(days3[i]==null?new BigDecimal(0):days3[i]);
			}
		} else {
			result = null;
		}
		
		return result;
	}
	
	public BigDecimal getResultTotals1(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < fastigiums.length; i++) {
			result= result.add(fastigiums[i]==null?new BigDecimal(0):fastigiums[i]);
		}
		this.resultTotals1 = result;
		return resultTotals1;
	}
	
	public BigDecimal getGpsResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < days.length; i++) {
			result= result.add(days[i]==null?new BigDecimal(0):days[i]);
		}
		return result.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getGpsResultTotals1(){
		BigDecimal result = new BigDecimal(0);
		BigDecimal result0 = new BigDecimal(0);
		BigDecimal result1 = new BigDecimal(0);
		BigDecimal result3 = new BigDecimal(0);
		if (null != days) {
			for (int i = 0; i < days.length; i++) {
				result0= result.add(days[i]==null?new BigDecimal(0):days[i]);
			}
		}
		
		if (null != days1) {
			for (int j = 0; j < days1.length; j++) {
				result1= result1.add(days1[j]==null?new BigDecimal(0):days1[j]);
			}
		}
		
		if (null != days3) {
			for (int k = 0; k < days3.length; k++) {
				result3= result3.add(days3[k]==null?new BigDecimal(0):days3[k]);
			}
		}
		
		result = result0.add(result1).add(result3).setScale(2, BigDecimal.ROUND_HALF_UP);
		return result;
	}
	
	public BigDecimal getAvgSpeedResultTotals(){
		BigDecimal m = new BigDecimal(days.length);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < days.length; i++) {
			result= result.add(days[i]==null?new BigDecimal(0):days[i]);
		}
		return BigDecimal.valueOf(Math.round(Double.valueOf(result.divide(m, mc).toString())));
	}
	
	public BigDecimal getHAvgSpeedResultTotals(){
		BigDecimal m = new BigDecimal(days1.length);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < days1.length; i++) {
			result= result.add(days1[i]==null?new BigDecimal(0):days1[i]);
		}
		return BigDecimal.valueOf(Math.round(Double.valueOf(result.divide(m, mc).toString())));
	}

	/**
	 * @return the avgSpeedTotals
	 */
	public String getAvgSpeedTotals() {
		return avgSpeedTotals;
	}

	/**
	 * @param avgSpeedTotals the avgSpeedTotals to set
	 */
	public void setAvgSpeedTotals(String avgSpeedTotals) {
		this.avgSpeedTotals = avgSpeedTotals;
	}

	/**
	 * @return the blackTypeCode
	 */
	public String getBlackTypeCode() {
		return blackTypeCode;
	}

	/**
	 * @param blackTypeCode the blackTypeCode to set
	 */
	public void setBlackTypeCode(String blackTypeCode) {
		this.blackTypeCode = blackTypeCode;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the telnumber
	 */
	public String getTelnumber() {
		return telnumber;
	}

	/**
	 * @param telnumber the telnumber to set
	 */
	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	/**
	 * @return the days1
	 */
	public BigDecimal[] getDays1() {
		return days1;
	}

	/**
	 * @param days1 the days1 to set
	 */
	public void setDays1(BigDecimal[] days1) {
		this.days1 = days1;
	}

	/**
	 * @return the flowNumber
	 */
	public int getFlowNumber() {
		return flowNumber;
	}

	/**
	 * @param flowNumber the flowNumber to set
	 */
	public void setFlowNumber(int flowNumber) {
		this.flowNumber = flowNumber;
	}

	/**
	 * @return the speedNumber
	 */
	public BigDecimal getSpeedNumber() {
		return speedNumber;
	}

	/**
	 * @param speedNumber the speedNumber to set
	 */
	public void setSpeedNumber(BigDecimal speedNumber) {
		this.speedNumber = speedNumber;
	}

	/**
	 * @return the dayTime
	 */
	public String getDayTime() {
		return dayTime;
	}

	/**
	 * @param dayTime the dayTime to set
	 */
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
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
	 * @return the days2
	 */
	public double[] getDays2() {
		return days2;
	}

	/**
	 * @param days2 the days2 to set
	 */
	public void setDays2(double[] days2) {
		this.days2 = days2;
	}

	/**
	 * @return the nolocalCounts
	 */
	public int getNolocalCounts() {
		return nolocalCounts;
	}

	/**
	 * @param nolocalCounts the nolocalCounts to set
	 */
	public void setNolocalCounts(int nolocalCounts) {
		this.nolocalCounts = nolocalCounts;
	}

	/**
	 * @return the noLocalNumber
	 */
	public int getNoLocalNumber() {
		return noLocalNumber;
	}

	/**
	 * @param noLocalNumber the noLocalNumber to set
	 */
	public void setNoLocalNumber(int noLocalNumber) {
		this.noLocalNumber = noLocalNumber;
	}

	/**
	 * @return the precent
	 */
	public double getPrecent() {
		return precent;
	}

	/**
	 * @param precent the precent to set
	 */
	public void setPrecent(double precent) {
		this.precent = precent;
	}

	/**
	 * @return the notknownCounts
	 */
	public int getNotknownCounts() {
		return notknownCounts;
	}

	/**
	 * @param notknownCounts the notknownCounts to set
	 */
	public void setNotknownCounts(int notknownCounts) {
		this.notknownCounts = notknownCounts;
	}

	/**
	 * @return the localCounts
	 */
	public int getLocalCounts() {
		return localCounts;
	}

	/**
	 * @param localCounts the localCounts to set
	 */
	public void setLocalCounts(int localCounts) {
		this.localCounts = localCounts;
	}

	/**
	 * @return the blackAlarmNumber
	 */
	public int getBlackAlarmNumber() {
		return blackAlarmNumber;
	}

	/**
	 * @param blackAlarmNumber the blackAlarmNumber to set
	 */
	public void setBlackAlarmNumber(int blackAlarmNumber) {
		this.blackAlarmNumber = blackAlarmNumber;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	
	/**
	 * @return the roadOrg
	 */
	public String getRoadOrg() {
		return roadOrg;
	}

	/**
	 * @param roadOrg the roadOrg to set
	 */
	public void setRoadOrg(String roadOrg) {
		this.roadOrg = roadOrg;
	}
	
	/**
	 * @return the daysOccupy
	 */
	public String[] getDaysOccupy() {
		return daysOccupy;
	}

	/**
	 * @param daysOccupy the daysOccupy to set
	 */
	public void setDaysOccupy(String[] daysOccupy) {
		this.daysOccupy = daysOccupy;
	}
	
	/**
	 * @return the delayValue
	 */
	public BigDecimal[] getDelayValue() {
		return delayValue;
	}

	/**
	 * @param delayValue the delayValue to set
	 */
	public void setDelayValue(BigDecimal[] delayValue) {
		this.delayValue = delayValue;
	}

	/**
	 * @return the finishValue
	 */
	public BigDecimal[] getFinishValue() {
		return finishValue;
	}

	/**
	 * @param finishValue the finishValue to set
	 */
	public void setFinishValue(BigDecimal[] finishValue) {
		this.finishValue = finishValue;
	}
	
	/**
	 * @return the delayCount
	 */
	public BigDecimal getDelayCount() {
		return delayCount;
	}

	/**
	 * @param delayCount the delayCount to set
	 */
	public void setDelayCount(BigDecimal delayCount) {
		this.delayCount = delayCount;
	}

	/**
	 * @return the finishCount
	 */
	public BigDecimal getFinishCount() {
		return finishCount;
	}

	/**
	 * @param finishCount the finishCount to set
	 */
	public void setFinishCount(BigDecimal finishCount) {
		this.finishCount = finishCount;
	}
	
	/**
	 * @return the builderId
	 */
	public String getBuilderId() {
		return builderId;
	}

	/**
	 * @param builderId the builderId to set
	 */
	public void setBuilderId(String builderId) {
		this.builderId = builderId;
	}
	
	/**
	 * @return the builderName
	 */
	public String getBuilderName() {
		return builderName;
	}

	/**
	 * @param builderName the builderName to set
	 */
	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}
	
	/**
	 * @return the roadType
	 */
	public String getRoadType() {
		return roadType;
	}

	/**
	 * @param roadType the roadType to set
	 */
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	
	/**
	 * @return the roadTypeName
	 */
	public String getRoadTypeName() {
		return roadTypeName;
	}

	/**
	 * @param roadTypeName the roadTypeName to set
	 */
	public void setRoadTypeName(String roadTypeName) {
		this.roadTypeName = roadTypeName;
	}
	
	/**
	 * @return the daysOccupy2
	 */
	public String[][] getDaysOccupy2() {
		return daysOccupy2;
	}

	/**
	 * @param daysOccupy2 the daysOccupy2 to set
	 */
	public void setDaysOccupy2(String[][] daysOccupy2) {
		this.daysOccupy2 = daysOccupy2;
	}
	
	

	/**
	 * @return the dayPrecents2
	 */
	public String[][] getDayPrecents2() {
		return dayPrecents2;
	}

	/**
	 * @param dayPrecents2 the dayPrecents2 to set
	 */
	public void setDayPrecents2(String[][] dayPrecents2) {
		this.dayPrecents2 = dayPrecents2;
	}
	
	/**
	 * @return the days3
	 */
	public BigDecimal[] getDays3() {
		return days3;
	}

	/**
	 * @param days3 the days3 to set
	 */
	public void setDays3(BigDecimal[] days3) {
		this.days3 = days3;
	}

	/**
	 * 重写equals方法，用于环比数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof MonthReport) {
			MonthReport monthReport = (MonthReport) obj;
			String roadId = monthReport.getRoadId()==null?"":monthReport.getRoadId();
			String directCode = monthReport.getDirectCode();
			return (roadId.equals(this.roadId) && directCode.equals(this.directCode));
			
		}else{
			return false;
		}
			
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @param resultTotals1 the resultTotals1 to set
	 */
	public void setResultTotals1(BigDecimal resultTotals1) {
		this.resultTotals1 = resultTotals1;
	}

	/**
	 * @return the fastigiums
	 */
	public BigDecimal[] getFastigiums() {
		return fastigiums;
	}

	/**
	 * @param fastigiums the fastigiums to set
	 */
	public void setFastigiums(BigDecimal[] fastigiums) {
		this.fastigiums = fastigiums;
	}

	/**
	 * @return the blueCounts
	 */
	public int getBlueCounts() {
		return blueCounts;
	}

	/**
	 * @param blueCounts the blueCounts to set
	 */
	public void setBlueCounts(int blueCounts) {
		this.blueCounts = blueCounts;
	}

	/**
	 * @return the yellowCounts
	 */
	public int getYellowCounts() {
		return yellowCounts;
	}

	/**
	 * @param yellowCounts the yellowCounts to set
	 */
	public void setYellowCounts(int yellowCounts) {
		this.yellowCounts = yellowCounts;
	}

	/**
	 * @return the dayFlows
	 */
	public String[][] getDayFlows() {
		return dayFlows;
	}

	/**
	 * @param dayFlows the dayFlows to set
	 */
	public void setDayFlows(String[][] dayFlows) {
		this.dayFlows = dayFlows;
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
	 * @return the htotals
	 */
	public BigDecimal getHtotals() {
		return htotals;
	}

	/**
	 * @param htotals the htotals to set
	 */
	public void setHtotals(BigDecimal htotals) {
		this.htotals = htotals;
	}

	/**
	 * @return the otherCounts
	 */
	public int getOtherCounts() {
		return otherCounts;
	}

	/**
	 * @param otherCounts the otherCounts to set
	 */
	public void setOtherCounts(int otherCounts) {
		this.otherCounts = otherCounts;
	}

	/**
	 * @return the ctotals
	 */
	public BigDecimal getCtotals() {
		return ctotals;
	}

	/**
	 * @param ctotals the ctotals to set
	 */
	public void setCtotals(BigDecimal ctotals) {
		this.ctotals = ctotals;
	}

	/**
	 * @return the ototals
	 */
	public BigDecimal getOtotals() {
		return ototals;
	}

	/**
	 * @param ototals the ototals to set
	 */
	public void setOtotals(BigDecimal ototals) {
		this.ototals = ototals;
	}

	/**
	 * @return the daysT
	 */
	public BigDecimal[] getDaysT() {
		return daysT;
	}

	/**
	 * @param daysT the daysT to set
	 */
	public void setDaysT(BigDecimal[] daysT) {
		this.daysT = daysT;
	}

	/**
	 * @return the daysTa
	 */
	public BigDecimal[] getDaysTa() {
		return daysTa;
	}

	/**
	 * @param daysTa the daysTa to set
	 */
	public void setDaysTa(BigDecimal[] daysTa) {
		this.daysTa = daysTa;
	}

	/**
	 * @return the daysTs
	 */
	public BigDecimal[] getDaysTs() {
		return daysTs;
	}

	/**
	 * @param daysTs the daysTs to set
	 */
	public void setDaysTs(BigDecimal[] daysTs) {
		this.daysTs = daysTs;
	}

	/**
	 * @return the havgSpeedTotals
	 */
	public String getHavgSpeedTotals() {
		return havgSpeedTotals;
	}

	/**
	 * @param havgSpeedTotals the havgSpeedTotals to set
	 */
	public void setHavgSpeedTotals(String havgSpeedTotals) {
		this.havgSpeedTotals = havgSpeedTotals;
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
	 * @return the nodenameStart
	 */
	public String getNodenameStart() {
		return nodenameStart;
	}

	/**
	 * @param nodenameStart the nodenameStart to set
	 */
	public void setNodenameStart(String nodenameStart) {
		this.nodenameStart = nodenameStart;
	}

	/**
	 * @return the nodenameEnd
	 */
	public String getNodenameEnd() {
		return nodenameEnd;
	}

	/**
	 * @param nodenameEnd the nodenameEnd to set
	 */
	public void setNodenameEnd(String nodenameEnd) {
		this.nodenameEnd = nodenameEnd;
	}
	
}
