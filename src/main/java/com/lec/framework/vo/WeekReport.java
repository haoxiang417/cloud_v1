package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/***
 * 周报表数据封装类
 * @author zhouhaij
 */
public class WeekReport implements Serializable{
	
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
	private BigDecimal hbparams;
	/***
	 * 设备名称
	 */
	private String deviceName;
	/***
	 * 一周的总和
	 */
	private BigDecimal totals;
	private BigDecimal htotals;
	private BigDecimal colorTotals;
	private BigDecimal ccolorTotals;
	private BigDecimal ocolorTotals;

	private BigDecimal resultTotals;
	private BigDecimal dresultTotals;
	private BigDecimal aresultTotals;
	private BigDecimal sresultTotals;
	
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
	//其他号牌车辆数
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
	
	
	/***
	 * 一周的总和 平均速度
	 */
	private BigDecimal avgSpeedTotals;
	private BigDecimal havgSpeedTotals;
	
	/***以下为各天小时的数据***/
	private BigDecimal d01;
	private BigDecimal d02;
	private BigDecimal d03;
	private BigDecimal d04;
	private BigDecimal d05;
	private BigDecimal d06;
	private BigDecimal d07;
	
	private BigDecimal cd01;
	private BigDecimal cd02;
	private BigDecimal cd03;
	private BigDecimal cd04;
	private BigDecimal cd05;
	private BigDecimal cd06;
	private BigDecimal cd07;
	
	private BigDecimal od01;
	private BigDecimal od02;
	private BigDecimal od03;
	private BigDecimal od04;
	private BigDecimal od05;
	private BigDecimal od06;
	private BigDecimal od07;
	
	private BigDecimal nd01;
	private BigDecimal nd02;
	private BigDecimal nd03;
	private BigDecimal nd04;
	private BigDecimal nd05;
	private BigDecimal nd06;
	private BigDecimal nd07;
	
	private double p01;
	private double p02;
	private double p03;
	private double p04;
	private double p05;
	private double p06;
	private double p07;
	/***各天数据结束***/
	
	/***
	 * 一周的星期几
	 */
	private String[] days;
	
	private BigDecimal[] fastigiums;
	private BigDecimal[] dfastigiums;
	private BigDecimal[] afastigiums;
	private BigDecimal[] sfastigiums;

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
		
		BigDecimal[] datas = new BigDecimal[]{d01,d02,d03,d04,d05,d06,d07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.totals = result;
		return totals;
	}
	
	public BigDecimal getHTotals(){
		BigDecimal[] datas = new BigDecimal[]{cd01,cd02,cd03,cd04,cd05,cd06,cd07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.htotals = result;
		return htotals;
	}
	
	public BigDecimal getColorTotals() {
		
		BigDecimal[] datas = new BigDecimal[]{d01,d02,d03,d04,d05,d06,d07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.colorTotals = result;
		return colorTotals;
	}
	
	public BigDecimal getCColorTotals() {
		
		BigDecimal[] datas = new BigDecimal[]{cd02,cd03,cd04,cd05,cd06,cd07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.ccolorTotals = result;
		return ccolorTotals;
	}

	public BigDecimal getOColorTotals() {
	
		BigDecimal[] datas = new BigDecimal[]{od01,od02,od03,od04,od05,od06,od07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.ocolorTotals = result;
		return ocolorTotals;
	}
	
	public BigDecimal getResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < fastigiums.length; i++) {
			result= result.add(fastigiums[i]==null?new BigDecimal(0):fastigiums[i]);
		}
		this.resultTotals = result;
		return resultTotals;
	}
	/**
	 * 高峰时段流量 车辆数
	 * @return
	 */
	public BigDecimal getDResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < dfastigiums.length; i++) {
			result= result.add(dfastigiums[i]==null?new BigDecimal(0):dfastigiums[i]);
		}
		this.resultTotals = result;
		return resultTotals;
	}
	
	/**
	 * 高峰时段流量 平均数
	 * @return
	 */
	public BigDecimal getAResultTotals(){
		BigDecimal m = new BigDecimal(afastigiums.length);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < afastigiums.length; i++) {
			result= result.add(afastigiums[i]==null?new BigDecimal(0):afastigiums[i]);
		}
		return result.divide(m, mc);
	}
	
	/**
	 * 高峰时段流量 速度
	 * @return
	 */
	public BigDecimal getSResultTotals(){
		BigDecimal m = new BigDecimal(sfastigiums.length);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < sfastigiums.length; i++) {
			result= result.add(sfastigiums[i]==null?new BigDecimal(0):sfastigiums[i]);
		}
		return result.divide(m, mc);
	}
	
	/**
	 * @return the totals
	 */
	public BigDecimal getAvgSpeedTotals() {
		BigDecimal w = new BigDecimal(7);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		
		BigDecimal[] datas = new BigDecimal[]{d01,d02,d03,d04,d05,d06,d07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.avgSpeedTotals = BigDecimal.valueOf(Math.round(Double.valueOf(result.divide(w,mc).toString())));
		return avgSpeedTotals;
	}
	
	/**
	 * @return the totals
	 */
	public BigDecimal getHAvgSpeedTotals() {
		BigDecimal w = new BigDecimal(7);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		
		BigDecimal[] datas = new BigDecimal[]{cd01,cd02,cd03,cd04,cd05,cd06,cd07};
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < datas.length; i++) {
			result= result.add(datas[i]);
		}
		this.havgSpeedTotals = BigDecimal.valueOf(Math.round(Double.valueOf(result.divide(w,mc).toString())));
		return havgSpeedTotals;
	}
	
	/**
	 * @param colorTotals the colorTotals to set
	 */
	public void setColorTotals(BigDecimal colorTotals) {
		this.colorTotals = colorTotals;
	}

	/**
	 * @param totals the totals to set
	 */
	public void setAvgSpeedTotals(BigDecimal avgSpeedTotals) {
		this.avgSpeedTotals = avgSpeedTotals;
	}
	
	/**
	 * @param totals the totals to set
	 */
	public void setTotals(BigDecimal totals) {
		this.totals = totals;
	}

	/**
	 * @return the d01
	 */
	public BigDecimal getD01() {
		return d01;
	}

	/**
	 * @param d01 the d01 to set
	 */
	public void setD01(BigDecimal d01) {
		this.d01 = d01;
	}

	/**
	 * @return the d02
	 */
	public BigDecimal getD02() {
		return d02;
	}

	/**
	 * @param d02 the d02 to set
	 */
	public void setD02(BigDecimal d02) {
		this.d02 = d02;
	}

	/**
	 * @return the d03
	 */
	public BigDecimal getD03() {
		return d03;
	}

	/**
	 * @param d03 the d03 to set
	 */
	public void setD03(BigDecimal d03) {
		this.d03 = d03;
	}

	/**
	 * @return the d04
	 */
	public BigDecimal getD04() {
		return d04;
	}

	/**
	 * @param d04 the d04 to set
	 */
	public void setD04(BigDecimal d04) {
		this.d04 = d04;
	}

	/**
	 * @return the d05
	 */
	public BigDecimal getD05() {
		return d05;
	}

	/**
	 * @param d05 the d05 to set
	 */
	public void setD05(BigDecimal d05) {
		this.d05 = d05;
	}

	/**
	 * @return the d06
	 */
	public BigDecimal getD06() {
		return d06;
	}

	/**
	 * @param d06 the d06 to set
	 */
	public void setD06(BigDecimal d06) {
		this.d06 = d06;
	}

	/**
	 * @return the d07
	 */
	public BigDecimal getD07() {
		return d07;
	}

	/**
	 * @param d07 the d07 to set
	 */
	public void setD07(BigDecimal d07) {
		this.d07 = d07;
	}

	/**
	 * @return the days
	 */
	public String[] getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(String[] days) {
		this.days = days;
	}

	/**
	 * @return the cd01
	 */
	public BigDecimal getCd01() {
		return cd01;
	}

	/**
	 * @param cd01 the cd01 to set
	 */
	public void setCd01(BigDecimal cd01) {
		this.cd01 = cd01;
	}

	/**
	 * @return the cd02
	 */
	public BigDecimal getCd02() {
		return cd02;
	}

	/**
	 * @param cd02 the cd02 to set
	 */
	public void setCd02(BigDecimal cd02) {
		this.cd02 = cd02;
	}

	/**
	 * @return the cd03
	 */
	public BigDecimal getCd03() {
		return cd03;
	}

	/**
	 * @param cd03 the cd03 to set
	 */
	public void setCd03(BigDecimal cd03) {
		this.cd03 = cd03;
	}

	/**
	 * @return the cd04
	 */
	public BigDecimal getCd04() {
		return cd04;
	}

	/**
	 * @param cd04 the cd04 to set
	 */
	public void setCd04(BigDecimal cd04) {
		this.cd04 = cd04;
	}

	/**
	 * @return the cd05
	 */
	public BigDecimal getCd05() {
		return cd05;
	}

	/**
	 * @param cd05 the cd05 to set
	 */
	public void setCd05(BigDecimal cd05) {
		this.cd05 = cd05;
	}

	/**
	 * @return the cd06
	 */
	public BigDecimal getCd06() {
		return cd06;
	}

	/**
	 * @param cd06 the cd06 to set
	 */
	public void setCd06(BigDecimal cd06) {
		this.cd06 = cd06;
	}

	/**
	 * @return the cd07
	 */
	public BigDecimal getCd07() {
		return cd07;
	}

	/**
	 * @param cd07 the cd07 to set
	 */
	public void setCd07(BigDecimal cd07) {
		this.cd07 = cd07;
	}

	/**
	 * @return the p01
	 */
	public double getP01() {
		return p01;
	}

	/**
	 * @param p01 the p01 to set
	 */
	public void setP01(double p01) {
		this.p01 = p01;
	}

	/**
	 * @return the p02
	 */
	public double getP02() {
		return p02;
	}

	/**
	 * @param p02 the p02 to set
	 */
	public void setP02(double p02) {
		this.p02 = p02;
	}

	/**
	 * @return the p03
	 */
	public double getP03() {
		return p03;
	}

	/**
	 * @param p03 the p03 to set
	 */
	public void setP03(double p03) {
		this.p03 = p03;
	}

	/**
	 * @return the p04
	 */
	public double getP04() {
		return p04;
	}

	/**
	 * @param p04 the p04 to set
	 */
	public void setP04(double p04) {
		this.p04 = p04;
	}

	/**
	 * @return the p05
	 */
	public double getP05() {
		return p05;
	}

	/**
	 * @param p05 the p05 to set
	 */
	public void setP05(double p05) {
		this.p05 = p05;
	}

	/**
	 * @return the p06
	 */
	public double getP06() {
		return p06;
	}

	/**
	 * @param p06 the p06 to set
	 */
	public void setP06(double p06) {
		this.p06 = p06;
	}

	/**
	 * @return the p07
	 */
	public double getP07() {
		return p07;
	}

	/**
	 * @param p07 the p07 to set
	 */
	public void setP07(double p07) {
		this.p07 = p07;
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
	 * @param resultTotals the resultTotals to set
	 */
	public void setResultTotals(BigDecimal resultTotals) {
		this.resultTotals = resultTotals;
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
	 * @return the ccolorTotals
	 */
	public BigDecimal getCcolorTotals() {
		return ccolorTotals;
	}

	/**
	 * @param ccolorTotals the ccolorTotals to set
	 */
	public void setCcolorTotals(BigDecimal ccolorTotals) {
		this.ccolorTotals = ccolorTotals;
	}

	/**
	 * @return the ocolorTotals
	 */
	public BigDecimal getOcolorTotals() {
		return ocolorTotals;
	}

	/**
	 * @param ocolorTotals the ocolorTotals to set
	 */
	public void setOcolorTotals(BigDecimal ocolorTotals) {
		this.ocolorTotals = ocolorTotals;
	}

	/**
	 * @return the od01
	 */
	public BigDecimal getOd01() {
		return od01;
	}

	/**
	 * @param od01 the od01 to set
	 */
	public void setOd01(BigDecimal od01) {
		this.od01 = od01;
	}

	/**
	 * @return the od02
	 */
	public BigDecimal getOd02() {
		return od02;
	}

	/**
	 * @param od02 the od02 to set
	 */
	public void setOd02(BigDecimal od02) {
		this.od02 = od02;
	}

	/**
	 * @return the od03
	 */
	public BigDecimal getOd03() {
		return od03;
	}

	/**
	 * @param od03 the od03 to set
	 */
	public void setOd03(BigDecimal od03) {
		this.od03 = od03;
	}

	/**
	 * @return the od04
	 */
	public BigDecimal getOd04() {
		return od04;
	}

	/**
	 * @param od04 the od04 to set
	 */
	public void setOd04(BigDecimal od04) {
		this.od04 = od04;
	}

	/**
	 * @return the od05
	 */
	public BigDecimal getOd05() {
		return od05;
	}

	/**
	 * @param od05 the od05 to set
	 */
	public void setOd05(BigDecimal od05) {
		this.od05 = od05;
	}

	/**
	 * @return the od06
	 */
	public BigDecimal getOd06() {
		return od06;
	}

	/**
	 * @param od06 the od06 to set
	 */
	public void setOd06(BigDecimal od06) {
		this.od06 = od06;
	}

	/**
	 * @return the od07
	 */
	public BigDecimal getOd07() {
		return od07;
	}

	/**
	 * @param od07 the od07 to set
	 */
	public void setOd07(BigDecimal od07) {
		this.od07 = od07;
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
	 * @return the dfastigiums
	 */
	public BigDecimal[] getDfastigiums() {
		return dfastigiums;
	}

	/**
	 * @param dfastigiums the dfastigiums to set
	 */
	public void setDfastigiums(BigDecimal[] dfastigiums) {
		this.dfastigiums = dfastigiums;
	}

	/**
	 * @return the afastigiums
	 */
	public BigDecimal[] getAfastigiums() {
		return afastigiums;
	}

	/**
	 * @param afastigiums the afastigiums to set
	 */
	public void setAfastigiums(BigDecimal[] afastigiums) {
		this.afastigiums = afastigiums;
	}

	/**
	 * @return the sfastigiums
	 */
	public BigDecimal[] getSfastigiums() {
		return sfastigiums;
	}

	/**
	 * @param sfastigiums the sfastigiums to set
	 */
	public void setSfastigiums(BigDecimal[] sfastigiums) {
		this.sfastigiums = sfastigiums;
	}
	
	/**
	 * @return the dresultTotals
	 */
	public BigDecimal getDresultTotals() {
		return dresultTotals;
	}

	/**
	 * @param dresultTotals the dresultTotals to set
	 */
	public void setDresultTotals(BigDecimal dresultTotals) {
		this.dresultTotals = dresultTotals;
	}

	/**
	 * @return the aresultTotals
	 */
	public BigDecimal getAresultTotals() {
		return aresultTotals;
	}

	/**
	 * @param aresultTotals the aresultTotals to set
	 */
	public void setAresultTotals(BigDecimal aresultTotals) {
		this.aresultTotals = aresultTotals;
	}

	/**
	 * @return the sresultTotals
	 */
	public BigDecimal getSresultTotals() {
		return sresultTotals;
	}

	/**
	 * @param sresultTotals the sresultTotals to set
	 */
	public void setSresultTotals(BigDecimal sresultTotals) {
		this.sresultTotals = sresultTotals;
	}
	
	/**
	 * @return the havgSpeedTotals
	 */
	public BigDecimal getHavgSpeedTotals() {
		return havgSpeedTotals;
	}

	/**
	 * @param havgSpeedTotals the havgSpeedTotals to set
	 */
	public void setHavgSpeedTotals(BigDecimal havgSpeedTotals) {
		this.havgSpeedTotals = havgSpeedTotals;
	}
	
	/**
	 * @return the nd01
	 */
	public BigDecimal getNd01() {
		return nd01;
	}

	/**
	 * @param nd01 the nd01 to set
	 */
	public void setNd01(BigDecimal nd01) {
		this.nd01 = nd01;
	}

	/**
	 * @return the nd02
	 */
	public BigDecimal getNd02() {
		return nd02;
	}

	/**
	 * @param nd02 the nd02 to set
	 */
	public void setNd02(BigDecimal nd02) {
		this.nd02 = nd02;
	}

	/**
	 * @return the nd03
	 */
	public BigDecimal getNd03() {
		return nd03;
	}

	/**
	 * @param nd03 the nd03 to set
	 */
	public void setNd03(BigDecimal nd03) {
		this.nd03 = nd03;
	}

	/**
	 * @return the nd04
	 */
	public BigDecimal getNd04() {
		return nd04;
	}

	/**
	 * @param nd04 the nd04 to set
	 */
	public void setNd04(BigDecimal nd04) {
		this.nd04 = nd04;
	}

	/**
	 * @return the nd05
	 */
	public BigDecimal getNd05() {
		return nd05;
	}

	/**
	 * @param nd05 the nd05 to set
	 */
	public void setNd05(BigDecimal nd05) {
		this.nd05 = nd05;
	}

	/**
	 * @return the nd06
	 */
	public BigDecimal getNd06() {
		return nd06;
	}

	/**
	 * @param nd06 the nd06 to set
	 */
	public void setNd06(BigDecimal nd06) {
		this.nd06 = nd06;
	}

	/**
	 * @return the nd07
	 */
	public BigDecimal getNd07() {
		return nd07;
	}

	/**
	 * @param nd07 the nd07 to set
	 */
	public void setNd07(BigDecimal nd07) {
		this.nd07 = nd07;
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
	
	public BigDecimal getHbparams() {
		return hbparams;
	}

	public void setHbparams(BigDecimal hbparams) {
		this.hbparams = hbparams;
	}

	/**
	 * 重写equals方法，用于环比数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof WeekReport) {
			WeekReport weekReport = (WeekReport) obj;
			String roadId = weekReport.getRoadId()==null?"":weekReport.getRoadId();
			String directCode = weekReport.getDirectCode();
			return (roadId.equals(this.roadId) && directCode.equals(this.directCode));
			
		}else{
			return false;
		}
			
	}
	
	
	
}
