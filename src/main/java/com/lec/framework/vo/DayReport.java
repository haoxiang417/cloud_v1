package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/***
 * 按天统计的报表
 * @author zhouhaij
 */
public class DayReport implements Serializable{
	
	private static final long serialVersionUID = -8410433203223618940L;
	
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
	
	private int flowNumber = 0; //车辆数
	private BigDecimal speedNumber; //平均速度
	private String dayTime; //天日期
	
	private Long[] days;

	private String viewId;//前台道路标识符ID
	
	private String dataXml;//封装前台要显示的数据集合
	
	//车辆总数
	private int counts;
	private int hbcounts;
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
	 * 布控类型编号
	 */
	private String blackTypeCode;
	
	private BigDecimal[] fastigiums;
	private BigDecimal[] dfastigiums;
	private BigDecimal[] afastigiums;
	private BigDecimal[] sfastigiums;
	//add by 2014-08-18 添加高峰流量统计二维数组。
	private String[][] fastigiums2;
	
	/***以下为各个小时的数据***/
	private BigDecimal h00;
	private BigDecimal h01;
	private BigDecimal h02;
	private BigDecimal h03;
	private BigDecimal h04;
	private BigDecimal h05;
	private BigDecimal h06;
	private BigDecimal h07;
	private BigDecimal h08;
	private BigDecimal h09;
	private BigDecimal h10;
	private BigDecimal h11;
	private BigDecimal h12;
	private BigDecimal h13;
	private BigDecimal h14;
	private BigDecimal h15;
	private BigDecimal h16;
	private BigDecimal h17;
	private BigDecimal h18;
	private BigDecimal h19;
	private BigDecimal h20;
	private BigDecimal h21;
	private BigDecimal h22;
	private BigDecimal h23;
	private BigDecimal h24;
	
	private BigDecimal ch00;
	private BigDecimal ch01;
	private BigDecimal ch02;
	private BigDecimal ch03;
	private BigDecimal ch04;
	private BigDecimal ch05;
	private BigDecimal ch06;
	private BigDecimal ch07;
	private BigDecimal ch08;
	private BigDecimal ch09;
	private BigDecimal ch10;
	private BigDecimal ch11;
	private BigDecimal ch12;
	private BigDecimal ch13;
	private BigDecimal ch14;
	private BigDecimal ch15;
	private BigDecimal ch16;
	private BigDecimal ch17;
	private BigDecimal ch18;
	private BigDecimal ch19;
	private BigDecimal ch20;
	private BigDecimal ch21;
	private BigDecimal ch22;
	private BigDecimal ch23;
	private BigDecimal ch24;
	
	private BigDecimal oh00;
	private BigDecimal oh01;
	private BigDecimal oh02;
	private BigDecimal oh03;
	private BigDecimal oh04;
	private BigDecimal oh05;
	private BigDecimal oh06;
	private BigDecimal oh07;
	private BigDecimal oh08;
	private BigDecimal oh09;
	private BigDecimal oh10;
	private BigDecimal oh11;
	private BigDecimal oh12;
	private BigDecimal oh13;
	private BigDecimal oh14;
	private BigDecimal oh15;
	private BigDecimal oh16;
	private BigDecimal oh17;
	private BigDecimal oh18;
	private BigDecimal oh19;
	private BigDecimal oh20;
	private BigDecimal oh21;
	private BigDecimal oh22;
	private BigDecimal oh23;
	private BigDecimal oh24;
	
	
	private BigDecimal nh00;
	private BigDecimal nh01;
	private BigDecimal nh02;
	private BigDecimal nh03;
	private BigDecimal nh04;
	private BigDecimal nh05;
	private BigDecimal nh06;
	private BigDecimal nh07;
	private BigDecimal nh08;
	private BigDecimal nh09;
	private BigDecimal nh10;
	private BigDecimal nh11;
	private BigDecimal nh12;
	private BigDecimal nh13;
	private BigDecimal nh14;
	private BigDecimal nh15;
	private BigDecimal nh16;
	private BigDecimal nh17;
	private BigDecimal nh18;
	private BigDecimal nh19;
	private BigDecimal nh20;
	private BigDecimal nh21;
	private BigDecimal nh22;
	private BigDecimal nh23;
	private BigDecimal nh24;
	
	/**各小时数据结束***/
	
	/**
	 * 外地车辆占百分比
	 */
	private double p00;
	private double p01;
	private double p02;
	private double p03;
	private double p04;
	private double p05;
	private double p06;
	private double p07;
	private double p08;
	private double p09;
	private double p10;
	private double p11;
	private double p12;
	private double p13;
	private double p14;
	private double p15;
	private double p16;
	private double p17;
	private double p18;
	private double p19;
	private double p20;
	private double p21;
	private double p22;
	private double p23;
	private double p24;
	
	
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
	 * 24小时的总和
	 */
	private BigDecimal totals;
	private BigDecimal htotals;
	private BigDecimal ctotals;
	private BigDecimal ototals;
	
	private BigDecimal resultTotals;
	
	//路段名称
	private String roadName;
	//路段起点
	private String nodenameStart;
	//路段终点
	private String nodenameEnd;
	
	//检测器编号
	private String code;
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
	 * @return the h01
	 */
	public BigDecimal getH01() {
		return h01;
	}

	/**
	 * @param h01 the h01 to set
	 */
	public void setH01(BigDecimal h01) {
		this.h01 = h01;
	}

	/**
	 * @return the h02
	 */
	public BigDecimal getH02() {
		return h02;
	}

	/**
	 * @param h02 the h02 to set
	 */
	public void setH02(BigDecimal h02) {
		this.h02 = h02;
	}

	/**
	 * @return the h03
	 */
	public BigDecimal getH03() {
		return h03;
	}

	/**
	 * @param h03 the h03 to set
	 */
	public void setH03(BigDecimal h03) {
		this.h03 = h03;
	}

	/**
	 * @return the h04
	 */
	public BigDecimal getH04() {
		return h04;
	}

	/**
	 * @param h04 the h04 to set
	 */
	public void setH04(BigDecimal h04) {
		this.h04 = h04;
	}

	/**
	 * @return the h05
	 */
	public BigDecimal getH05() {
		return h05;
	}

	/**
	 * @param h05 the h05 to set
	 */
	public void setH05(BigDecimal h05) {
		this.h05 = h05;
	}

	/**
	 * @return the h06
	 */
	public BigDecimal getH06() {
		return h06;
	}

	/**
	 * @param h06 the h06 to set
	 */
	public void setH06(BigDecimal h06) {
		this.h06 = h06;
	}

	/**
	 * @return the h07
	 */
	public BigDecimal getH07() {
		return h07;
	}

	/**
	 * @param h07 the h07 to set
	 */
	public void setH07(BigDecimal h07) {
		this.h07 = h07;
	}

	/**
	 * @return the h08
	 */
	public BigDecimal getH08() {
		return h08;
	}

	/**
	 * @param h08 the h08 to set
	 */
	public void setH08(BigDecimal h08) {
		this.h08 = h08;
	}

	/**
	 * @return the h09
	 */
	public BigDecimal getH09() {
		return h09;
	}

	/**
	 * @param h09 the h09 to set
	 */
	public void setH09(BigDecimal h09) {
		this.h09 = h09;
	}

	/**
	 * @return the h10
	 */
	public BigDecimal getH10() {
		return h10;
	}

	/**
	 * @param h10 the h10 to set
	 */
	public void setH10(BigDecimal h10) {
		this.h10 = h10;
	}

	/**
	 * @return the h11
	 */
	public BigDecimal getH11() {
		return h11;
	}

	/**
	 * @param h11 the h11 to set
	 */
	public void setH11(BigDecimal h11) {
		this.h11 = h11;
	}

	/**
	 * @return the h12
	 */
	public BigDecimal getH12() {
		return h12;
	}

	/**
	 * @param h12 the h12 to set
	 */
	public void setH12(BigDecimal h12) {
		this.h12 = h12;
	}

	/**
	 * @return the h13
	 */
	public BigDecimal getH13() {
		return h13;
	}

	/**
	 * @param h13 the h13 to set
	 */
	public void setH13(BigDecimal h13) {
		this.h13 = h13;
	}

	/**
	 * @return the h14
	 */
	public BigDecimal getH14() {
		return h14;
	}

	/**
	 * @param h14 the h14 to set
	 */
	public void setH14(BigDecimal h14) {
		this.h14 = h14;
	}

	/**
	 * @return the h15
	 */
	public BigDecimal getH15() {
		return h15;
	}

	/**
	 * @param h15 the h15 to set
	 */
	public void setH15(BigDecimal h15) {
		this.h15 = h15;
	}

	/**
	 * @return the h16
	 */
	public BigDecimal getH16() {
		return h16;
	}

	/**
	 * @param h16 the h16 to set
	 */
	public void setH16(BigDecimal h16) {
		this.h16 = h16;
	}

	/**
	 * @return the h17
	 */
	public BigDecimal getH17() {
		return h17;
	}

	/**
	 * @param h17 the h17 to set
	 */
	public void setH17(BigDecimal h17) {
		this.h17 = h17;
	}

	/**
	 * @return the h18
	 */
	public BigDecimal getH18() {
		return h18;
	}

	/**
	 * @param h18 the h18 to set
	 */
	public void setH18(BigDecimal h18) {
		this.h18 = h18;
	}

	/**
	 * @return the h19
	 */
	public BigDecimal getH19() {
		return h19;
	}

	/**
	 * @param h19 the h19 to set
	 */
	public void setH19(BigDecimal h19) {
		this.h19 = h19;
	}

	/**
	 * @return the h20
	 */
	public BigDecimal getH20() {
		return h20;
	}

	/**
	 * @param h20 the h20 to set
	 */
	public void setH20(BigDecimal h20) {
		this.h20 = h20;
	}

	/**
	 * @return the h21
	 */
	public BigDecimal getH21() {
		return h21;
	}

	/**
	 * @param h21 the h21 to set
	 */
	public void setH21(BigDecimal h21) {
		this.h21 = h21;
	}

	/**
	 * @return the h22
	 */
	public BigDecimal getH22() {
		return h22;
	}

	/**
	 * @param h22 the h22 to set
	 */
	public void setH22(BigDecimal h22) {
		this.h22 = h22;
	}

	/**
	 * @return the h23
	 */
	public BigDecimal getH23() {
		return h23;
	}

	/**
	 * @param h23 the h23 to set
	 */
	public void setH23(BigDecimal h23) {
		this.h23 = h23;
	}

	/**
	 * @return the h24
	 */
	public BigDecimal getH24() {
		return h24;
	}

	/**
	 * @param h24 the h24 to set
	 */
	public void setH24(BigDecimal h24) {
		this.h24 = h24;
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
	
	public BigDecimal getRecordTotal(){
		return h01.add(h02).add(h03).add(h04).add(h05).add(h06
				).add(h07).add(h08).add(h09).add(h10).add(h11).add(h12
				).add(h13).add(h14).add(h15).add(h16).add(h17).add(h18
				).add(h19).add(h20).add(h21).add(h22).add(h23).add(h24);
	}
	
	public BigDecimal getHRecordTotal(){
		return ch01.add(ch02).add(ch03).add(ch04).add(ch05).add(ch06
				).add(ch07).add(ch08).add(ch09).add(ch10).add(ch11).add(ch12
				).add(ch13).add(ch14).add(ch15).add(ch16).add(ch17).add(ch18
				).add(ch19).add(ch20).add(ch21).add(ch22).add(ch23).add(ch24);
	}
	
	public BigDecimal getRecordTotalNew(){
		return h00.add(h01).add(h02).add(h03).add(h04).add(h05).add(h06
				).add(h07).add(h08).add(h09).add(h10).add(h11).add(h12
				).add(h13).add(h14).add(h15).add(h16).add(h17).add(h18
				).add(h19).add(h20).add(h21).add(h22).add(h23);
	}
	
	public BigDecimal getHRecordTotalNew(){
		return ch00.add(h01).add(ch02).add(ch03).add(ch04).add(ch05).add(ch06
				).add(ch07).add(ch08).add(ch09).add(ch10).add(ch11).add(ch12
				).add(ch13).add(ch14).add(ch15).add(ch16).add(ch17).add(ch18
				).add(ch19).add(ch20).add(ch21).add(ch22).add(ch23);
	}
	/**
	 * 计算蓝色号牌颜色流量统计数
	 * @return
	 */
	public BigDecimal getColorRecordTotal(){
		return h01.add(h02).add(h03).add(h04).add(h05).add(h06
				).add(h07).add(h08).add(h09).add(h10).add(h11).add(h12
				).add(h13).add(h14).add(h15).add(h16).add(h17).add(h18
				).add(h19).add(h20).add(h21).add(h22).add(h23).add(h24);
	}
	
	/**
	 * 计算黄色号牌颜色流量统计数
	 * @return
	 */
	public BigDecimal getCColorRecordTotal(){
		return ch01.add(ch02).add(ch03).add(ch04).add(ch05).add(ch06
				).add(ch07).add(ch08).add(ch09).add(ch10).add(ch11).add(ch12
				).add(ch13).add(ch14).add(ch15).add(ch16).add(ch17).add(ch18
				).add(ch19).add(ch20).add(ch21).add(ch22).add(ch23).add(ch24);
	}
	/**
	 * 计算其他号牌颜色流量统计数
	 * @return
	 */
	public BigDecimal getOColorRecordTotal(){
		return oh01.add(oh02).add(oh03).add(oh04).add(oh05).add(oh06
				).add(oh07).add(oh08).add(oh09).add(oh10).add(oh11).add(oh12
				).add(oh13).add(oh14).add(oh15).add(oh16).add(oh17).add(oh18
				).add(oh19).add(oh20).add(oh21).add(oh22).add(oh23).add(oh24);
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
		this.totals = result;
		return totals;
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
	
	public BigDecimal getAvgSpeedTotal(){
		BigDecimal h = new BigDecimal(24);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		return BigDecimal.valueOf(Math.round(Double.parseDouble((h01.add(h02).add(h03).add(h04).add(h05).add(h06
		).add(h07).add(h08).add(h09).add(h10).add(h11).add(h12
		).add(h13).add(h14).add(h15).add(h16).add(h17).add(h18
		).add(h19).add(h20).add(h21).add(h22).add(h23).add(h24)).divide(h, mc).toString())));
	}
	
	public BigDecimal getHAvgSpeedTotal(){
		BigDecimal h = new BigDecimal(24);
		MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
		return BigDecimal.valueOf(Math.round(Double.parseDouble((ch01.add(ch02).add(ch03).add(ch04).add(ch05).add(ch06
		).add(ch07).add(ch08).add(ch09).add(ch10).add(ch11).add(ch12
		).add(ch13).add(ch14).add(ch15).add(ch16).add(ch17).add(ch18
		).add(ch19).add(ch20).add(ch21).add(ch22).add(ch23).add(ch24)).divide(h, mc).toString())));
	}

	/**
	 * @return the ch01
	 */
	public BigDecimal getCh01() {
		return ch01;
	}

	/**
	 * @param ch01 the ch01 to set
	 */
	public void setCh01(BigDecimal ch01) {
		this.ch01 = ch01;
	}

	/**
	 * @return the ch02
	 */
	public BigDecimal getCh02() {
		return ch02;
	}

	/**
	 * @param ch02 the ch02 to set
	 */
	public void setCh02(BigDecimal ch02) {
		this.ch02 = ch02;
	}

	/**
	 * @return the ch03
	 */
	public BigDecimal getCh03() {
		return ch03;
	}

	/**
	 * @param ch03 the ch03 to set
	 */
	public void setCh03(BigDecimal ch03) {
		this.ch03 = ch03;
	}

	/**
	 * @return the ch04
	 */
	public BigDecimal getCh04() {
		return ch04;
	}

	/**
	 * @param ch04 the ch04 to set
	 */
	public void setCh04(BigDecimal ch04) {
		this.ch04 = ch04;
	}

	/**
	 * @return the ch05
	 */
	public BigDecimal getCh05() {
		return ch05;
	}

	/**
	 * @param ch05 the ch05 to set
	 */
	public void setCh05(BigDecimal ch05) {
		this.ch05 = ch05;
	}

	/**
	 * @return the ch06
	 */
	public BigDecimal getCh06() {
		return ch06;
	}

	/**
	 * @param ch06 the ch06 to set
	 */
	public void setCh06(BigDecimal ch06) {
		this.ch06 = ch06;
	}

	/**
	 * @return the ch07
	 */
	public BigDecimal getCh07() {
		return ch07;
	}

	/**
	 * @param ch07 the ch07 to set
	 */
	public void setCh07(BigDecimal ch07) {
		this.ch07 = ch07;
	}

	/**
	 * @return the ch08
	 */
	public BigDecimal getCh08() {
		return ch08;
	}

	/**
	 * @param ch08 the ch08 to set
	 */
	public void setCh08(BigDecimal ch08) {
		this.ch08 = ch08;
	}

	/**
	 * @return the ch09
	 */
	public BigDecimal getCh09() {
		return ch09;
	}

	/**
	 * @param ch09 the ch09 to set
	 */
	public void setCh09(BigDecimal ch09) {
		this.ch09 = ch09;
	}

	/**
	 * @return the ch10
	 */
	public BigDecimal getCh10() {
		return ch10;
	}

	/**
	 * @param ch10 the ch10 to set
	 */
	public void setCh10(BigDecimal ch10) {
		this.ch10 = ch10;
	}

	/**
	 * @return the ch11
	 */
	public BigDecimal getCh11() {
		return ch11;
	}

	/**
	 * @param ch11 the ch11 to set
	 */
	public void setCh11(BigDecimal ch11) {
		this.ch11 = ch11;
	}

	/**
	 * @return the ch12
	 */
	public BigDecimal getCh12() {
		return ch12;
	}

	/**
	 * @param ch12 the ch12 to set
	 */
	public void setCh12(BigDecimal ch12) {
		this.ch12 = ch12;
	}

	/**
	 * @return the ch13
	 */
	public BigDecimal getCh13() {
		return ch13;
	}

	/**
	 * @param ch13 the ch13 to set
	 */
	public void setCh13(BigDecimal ch13) {
		this.ch13 = ch13;
	}

	/**
	 * @return the ch14
	 */
	public BigDecimal getCh14() {
		return ch14;
	}

	/**
	 * @param ch14 the ch14 to set
	 */
	public void setCh14(BigDecimal ch14) {
		this.ch14 = ch14;
	}

	/**
	 * @return the ch15
	 */
	public BigDecimal getCh15() {
		return ch15;
	}

	/**
	 * @param ch15 the ch15 to set
	 */
	public void setCh15(BigDecimal ch15) {
		this.ch15 = ch15;
	}

	/**
	 * @return the ch16
	 */
	public BigDecimal getCh16() {
		return ch16;
	}

	/**
	 * @param ch16 the ch16 to set
	 */
	public void setCh16(BigDecimal ch16) {
		this.ch16 = ch16;
	}

	/**
	 * @return the ch17
	 */
	public BigDecimal getCh17() {
		return ch17;
	}

	/**
	 * @param ch17 the ch17 to set
	 */
	public void setCh17(BigDecimal ch17) {
		this.ch17 = ch17;
	}

	/**
	 * @return the ch18
	 */
	public BigDecimal getCh18() {
		return ch18;
	}

	/**
	 * @param ch18 the ch18 to set
	 */
	public void setCh18(BigDecimal ch18) {
		this.ch18 = ch18;
	}

	/**
	 * @return the ch19
	 */
	public BigDecimal getCh19() {
		return ch19;
	}

	/**
	 * @param ch19 the ch19 to set
	 */
	public void setCh19(BigDecimal ch19) {
		this.ch19 = ch19;
	}

	/**
	 * @return the ch20
	 */
	public BigDecimal getCh20() {
		return ch20;
	}

	/**
	 * @param ch20 the ch20 to set
	 */
	public void setCh20(BigDecimal ch20) {
		this.ch20 = ch20;
	}

	/**
	 * @return the ch21
	 */
	public BigDecimal getCh21() {
		return ch21;
	}

	/**
	 * @param ch21 the ch21 to set
	 */
	public void setCh21(BigDecimal ch21) {
		this.ch21 = ch21;
	}

	/**
	 * @return the ch22
	 */
	public BigDecimal getCh22() {
		return ch22;
	}

	/**
	 * @param ch22 the ch22 to set
	 */
	public void setCh22(BigDecimal ch22) {
		this.ch22 = ch22;
	}

	/**
	 * @return the ch23
	 */
	public BigDecimal getCh23() {
		return ch23;
	}

	/**
	 * @param ch23 the ch23 to set
	 */
	public void setCh23(BigDecimal ch23) {
		this.ch23 = ch23;
	}

	/**
	 * @return the ch24
	 */
	public BigDecimal getCh24() {
		return ch24;
	}

	/**
	 * @param ch24 the ch24 to set
	 */
	public void setCh24(BigDecimal ch24) {
		this.ch24 = ch24;
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
	 * @return the p08
	 */
	public double getP08() {
		return p08;
	}

	/**
	 * @param p08 the p08 to set
	 */
	public void setP08(double p08) {
		this.p08 = p08;
	}

	/**
	 * @return the p09
	 */
	public double getP09() {
		return p09;
	}

	/**
	 * @param p09 the p09 to set
	 */
	public void setP09(double p09) {
		this.p09 = p09;
	}

	/**
	 * @return the p10
	 */
	public double getP10() {
		return p10;
	}

	/**
	 * @param p10 the p10 to set
	 */
	public void setP10(double p10) {
		this.p10 = p10;
	}

	/**
	 * @return the p11
	 */
	public double getP11() {
		return p11;
	}

	/**
	 * @param p11 the p11 to set
	 */
	public void setP11(double p11) {
		this.p11 = p11;
	}

	/**
	 * @return the p12
	 */
	public double getP12() {
		return p12;
	}

	/**
	 * @param p12 the p12 to set
	 */
	public void setP12(double p12) {
		this.p12 = p12;
	}

	/**
	 * @return the p13
	 */
	public double getP13() {
		return p13;
	}

	/**
	 * @param p13 the p13 to set
	 */
	public void setP13(double p13) {
		this.p13 = p13;
	}

	/**
	 * @return the p14
	 */
	public double getP14() {
		return p14;
	}

	/**
	 * @param p14 the p14 to set
	 */
	public void setP14(double p14) {
		this.p14 = p14;
	}

	/**
	 * @return the p15
	 */
	public double getP15() {
		return p15;
	}

	/**
	 * @param p15 the p15 to set
	 */
	public void setP15(double p15) {
		this.p15 = p15;
	}

	/**
	 * @return the p16
	 */
	public double getP16() {
		return p16;
	}

	/**
	 * @param p16 the p16 to set
	 */
	public void setP16(double p16) {
		this.p16 = p16;
	}

	/**
	 * @return the p17
	 */
	public double getP17() {
		return p17;
	}

	/**
	 * @param p17 the p17 to set
	 */
	public void setP17(double p17) {
		this.p17 = p17;
	}

	/**
	 * @return the p18
	 */
	public double getP18() {
		return p18;
	}

	/**
	 * @param p18 the p18 to set
	 */
	public void setP18(double p18) {
		this.p18 = p18;
	}

	/**
	 * @return the p19
	 */
	public double getP19() {
		return p19;
	}

	/**
	 * @param p19 the p19 to set
	 */
	public void setP19(double p19) {
		this.p19 = p19;
	}

	/**
	 * @return the p20
	 */
	public double getP20() {
		return p20;
	}

	/**
	 * @param p20 the p20 to set
	 */
	public void setP20(double p20) {
		this.p20 = p20;
	}

	/**
	 * @return the p21
	 */
	public double getP21() {
		return p21;
	}

	/**
	 * @param p21 the p21 to set
	 */
	public void setP21(double p21) {
		this.p21 = p21;
	}

	/**
	 * @return the p22
	 */
	public double getP22() {
		return p22;
	}

	/**
	 * @param p22 the p22 to set
	 */
	public void setP22(double p22) {
		this.p22 = p22;
	}

	/**
	 * @return the p23
	 */
	public double getP23() {
		return p23;
	}

	/**
	 * @param p23 the p23 to set
	 */
	public void setP23(double p23) {
		this.p23 = p23;
	}

	/**
	 * @return the p24
	 */
	public double getP24() {
		return p24;
	}

	/**
	 * @param p24 the p24 to set
	 */
	public void setP24(double p24) {
		this.p24 = p24;
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
	 * @return the days
	 */
	public Long[] getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(Long[] days) {
		this.days = days;
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
	 * @return the fastigiums2
	 */
	public String[][] getFastigiums2() {
		return fastigiums2;
	}

	/**
	 * @param fastigiums2 the fastigiums2 to set
	 */
	public void setFastigiums2(String[][] fastigiums2) {
		this.fastigiums2 = fastigiums2;
	}
	
	/**
	 * @return the oh01
	 */
	public BigDecimal getOh01() {
		return oh01;
	}

	/**
	 * @param oh01 the oh01 to set
	 */
	public void setOh01(BigDecimal oh01) {
		this.oh01 = oh01;
	}

	/**
	 * @return the oh02
	 */
	public BigDecimal getOh02() {
		return oh02;
	}

	/**
	 * @param oh02 the oh02 to set
	 */
	public void setOh02(BigDecimal oh02) {
		this.oh02 = oh02;
	}

	/**
	 * @return the oh03
	 */
	public BigDecimal getOh03() {
		return oh03;
	}

	/**
	 * @param oh03 the oh03 to set
	 */
	public void setOh03(BigDecimal oh03) {
		this.oh03 = oh03;
	}

	/**
	 * @return the oh04
	 */
	public BigDecimal getOh04() {
		return oh04;
	}

	/**
	 * @param oh04 the oh04 to set
	 */
	public void setOh04(BigDecimal oh04) {
		this.oh04 = oh04;
	}

	/**
	 * @return the oh05
	 */
	public BigDecimal getOh05() {
		return oh05;
	}

	/**
	 * @param oh05 the oh05 to set
	 */
	public void setOh05(BigDecimal oh05) {
		this.oh05 = oh05;
	}

	/**
	 * @return the oh06
	 */
	public BigDecimal getOh06() {
		return oh06;
	}

	/**
	 * @param oh06 the oh06 to set
	 */
	public void setOh06(BigDecimal oh06) {
		this.oh06 = oh06;
	}

	/**
	 * @return the oh07
	 */
	public BigDecimal getOh07() {
		return oh07;
	}

	/**
	 * @param oh07 the oh07 to set
	 */
	public void setOh07(BigDecimal oh07) {
		this.oh07 = oh07;
	}

	/**
	 * @return the oh08
	 */
	public BigDecimal getOh08() {
		return oh08;
	}

	/**
	 * @param oh08 the oh08 to set
	 */
	public void setOh08(BigDecimal oh08) {
		this.oh08 = oh08;
	}

	/**
	 * @return the oh09
	 */
	public BigDecimal getOh09() {
		return oh09;
	}

	/**
	 * @param oh09 the oh09 to set
	 */
	public void setOh09(BigDecimal oh09) {
		this.oh09 = oh09;
	}

	/**
	 * @return the oh10
	 */
	public BigDecimal getOh10() {
		return oh10;
	}

	/**
	 * @param oh10 the oh10 to set
	 */
	public void setOh10(BigDecimal oh10) {
		this.oh10 = oh10;
	}

	/**
	 * @return the oh11
	 */
	public BigDecimal getOh11() {
		return oh11;
	}

	/**
	 * @param oh11 the oh11 to set
	 */
	public void setOh11(BigDecimal oh11) {
		this.oh11 = oh11;
	}

	/**
	 * @return the oh12
	 */
	public BigDecimal getOh12() {
		return oh12;
	}

	/**
	 * @param oh12 the oh12 to set
	 */
	public void setOh12(BigDecimal oh12) {
		this.oh12 = oh12;
	}

	/**
	 * @return the oh13
	 */
	public BigDecimal getOh13() {
		return oh13;
	}

	/**
	 * @param oh13 the oh13 to set
	 */
	public void setOh13(BigDecimal oh13) {
		this.oh13 = oh13;
	}

	/**
	 * @return the oh14
	 */
	public BigDecimal getOh14() {
		return oh14;
	}

	/**
	 * @param oh14 the oh14 to set
	 */
	public void setOh14(BigDecimal oh14) {
		this.oh14 = oh14;
	}

	/**
	 * @return the oh15
	 */
	public BigDecimal getOh15() {
		return oh15;
	}

	/**
	 * @param oh15 the oh15 to set
	 */
	public void setOh15(BigDecimal oh15) {
		this.oh15 = oh15;
	}

	/**
	 * @return the oh16
	 */
	public BigDecimal getOh16() {
		return oh16;
	}

	/**
	 * @param oh16 the oh16 to set
	 */
	public void setOh16(BigDecimal oh16) {
		this.oh16 = oh16;
	}

	/**
	 * @return the oh17
	 */
	public BigDecimal getOh17() {
		return oh17;
	}

	/**
	 * @param oh17 the oh17 to set
	 */
	public void setOh17(BigDecimal oh17) {
		this.oh17 = oh17;
	}

	/**
	 * @return the oh18
	 */
	public BigDecimal getOh18() {
		return oh18;
	}

	/**
	 * @param oh18 the oh18 to set
	 */
	public void setOh18(BigDecimal oh18) {
		this.oh18 = oh18;
	}

	/**
	 * @return the oh19
	 */
	public BigDecimal getOh19() {
		return oh19;
	}

	/**
	 * @param oh19 the oh19 to set
	 */
	public void setOh19(BigDecimal oh19) {
		this.oh19 = oh19;
	}

	/**
	 * @return the oh20
	 */
	public BigDecimal getOh20() {
		return oh20;
	}

	/**
	 * @param oh20 the oh20 to set
	 */
	public void setOh20(BigDecimal oh20) {
		this.oh20 = oh20;
	}

	/**
	 * @return the oh21
	 */
	public BigDecimal getOh21() {
		return oh21;
	}

	/**
	 * @param oh21 the oh21 to set
	 */
	public void setOh21(BigDecimal oh21) {
		this.oh21 = oh21;
	}

	/**
	 * @return the oh22
	 */
	public BigDecimal getOh22() {
		return oh22;
	}

	/**
	 * @param oh22 the oh22 to set
	 */
	public void setOh22(BigDecimal oh22) {
		this.oh22 = oh22;
	}

	/**
	 * @return the oh23
	 */
	public BigDecimal getOh23() {
		return oh23;
	}

	/**
	 * @param oh23 the oh23 to set
	 */
	public void setOh23(BigDecimal oh23) {
		this.oh23 = oh23;
	}

	/**
	 * @return the oh24
	 */
	public BigDecimal getOh24() {
		return oh24;
	}

	/**
	 * @param oh24 the oh24 to set
	 */
	public void setOh24(BigDecimal oh24) {
		this.oh24 = oh24;
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
	 * @return the nh01
	 */
	public BigDecimal getNh01() {
		return nh01;
	}

	/**
	 * @param nh01 the nh01 to set
	 */
	public void setNh01(BigDecimal nh01) {
		this.nh01 = nh01;
	}

	/**
	 * @return the nh02
	 */
	public BigDecimal getNh02() {
		return nh02;
	}

	/**
	 * @param nh02 the nh02 to set
	 */
	public void setNh02(BigDecimal nh02) {
		this.nh02 = nh02;
	}

	/**
	 * @return the nh03
	 */
	public BigDecimal getNh03() {
		return nh03;
	}

	/**
	 * @param nh03 the nh03 to set
	 */
	public void setNh03(BigDecimal nh03) {
		this.nh03 = nh03;
	}

	/**
	 * @return the nh04
	 */
	public BigDecimal getNh04() {
		return nh04;
	}

	/**
	 * @param nh04 the nh04 to set
	 */
	public void setNh04(BigDecimal nh04) {
		this.nh04 = nh04;
	}

	/**
	 * @return the nh05
	 */
	public BigDecimal getNh05() {
		return nh05;
	}

	/**
	 * @param nh05 the nh05 to set
	 */
	public void setNh05(BigDecimal nh05) {
		this.nh05 = nh05;
	}

	/**
	 * @return the nh06
	 */
	public BigDecimal getNh06() {
		return nh06;
	}

	/**
	 * @param nh06 the nh06 to set
	 */
	public void setNh06(BigDecimal nh06) {
		this.nh06 = nh06;
	}

	/**
	 * @return the nh07
	 */
	public BigDecimal getNh07() {
		return nh07;
	}

	/**
	 * @param nh07 the nh07 to set
	 */
	public void setNh07(BigDecimal nh07) {
		this.nh07 = nh07;
	}

	/**
	 * @return the nh08
	 */
	public BigDecimal getNh08() {
		return nh08;
	}

	/**
	 * @param nh08 the nh08 to set
	 */
	public void setNh08(BigDecimal nh08) {
		this.nh08 = nh08;
	}

	/**
	 * @return the nh09
	 */
	public BigDecimal getNh09() {
		return nh09;
	}

	/**
	 * @param nh09 the nh09 to set
	 */
	public void setNh09(BigDecimal nh09) {
		this.nh09 = nh09;
	}

	/**
	 * @return the nh10
	 */
	public BigDecimal getNh10() {
		return nh10;
	}

	/**
	 * @param nh10 the nh10 to set
	 */
	public void setNh10(BigDecimal nh10) {
		this.nh10 = nh10;
	}

	/**
	 * @return the nh11
	 */
	public BigDecimal getNh11() {
		return nh11;
	}

	/**
	 * @param nh11 the nh11 to set
	 */
	public void setNh11(BigDecimal nh11) {
		this.nh11 = nh11;
	}

	/**
	 * @return the nh12
	 */
	public BigDecimal getNh12() {
		return nh12;
	}

	/**
	 * @param nh12 the nh12 to set
	 */
	public void setNh12(BigDecimal nh12) {
		this.nh12 = nh12;
	}

	/**
	 * @return the nh13
	 */
	public BigDecimal getNh13() {
		return nh13;
	}

	/**
	 * @param nh13 the nh13 to set
	 */
	public void setNh13(BigDecimal nh13) {
		this.nh13 = nh13;
	}

	/**
	 * @return the nh14
	 */
	public BigDecimal getNh14() {
		return nh14;
	}

	/**
	 * @param nh14 the nh14 to set
	 */
	public void setNh14(BigDecimal nh14) {
		this.nh14 = nh14;
	}

	/**
	 * @return the nh15
	 */
	public BigDecimal getNh15() {
		return nh15;
	}

	/**
	 * @param nh15 the nh15 to set
	 */
	public void setNh15(BigDecimal nh15) {
		this.nh15 = nh15;
	}

	/**
	 * @return the nh16
	 */
	public BigDecimal getNh16() {
		return nh16;
	}

	/**
	 * @param nh16 the nh16 to set
	 */
	public void setNh16(BigDecimal nh16) {
		this.nh16 = nh16;
	}

	/**
	 * @return the nh17
	 */
	public BigDecimal getNh17() {
		return nh17;
	}

	/**
	 * @param nh17 the nh17 to set
	 */
	public void setNh17(BigDecimal nh17) {
		this.nh17 = nh17;
	}

	/**
	 * @return the nh18
	 */
	public BigDecimal getNh18() {
		return nh18;
	}

	/**
	 * @param nh18 the nh18 to set
	 */
	public void setNh18(BigDecimal nh18) {
		this.nh18 = nh18;
	}

	/**
	 * @return the nh19
	 */
	public BigDecimal getNh19() {
		return nh19;
	}

	/**
	 * @param nh19 the nh19 to set
	 */
	public void setNh19(BigDecimal nh19) {
		this.nh19 = nh19;
	}

	/**
	 * @return the nh20
	 */
	public BigDecimal getNh20() {
		return nh20;
	}

	/**
	 * @param nh20 the nh20 to set
	 */
	public void setNh20(BigDecimal nh20) {
		this.nh20 = nh20;
	}

	/**
	 * @return the nh21
	 */
	public BigDecimal getNh21() {
		return nh21;
	}

	/**
	 * @param nh21 the nh21 to set
	 */
	public void setNh21(BigDecimal nh21) {
		this.nh21 = nh21;
	}

	/**
	 * @return the nh22
	 */
	public BigDecimal getNh22() {
		return nh22;
	}

	/**
	 * @param nh22 the nh22 to set
	 */
	public void setNh22(BigDecimal nh22) {
		this.nh22 = nh22;
	}

	/**
	 * @return the nh23
	 */
	public BigDecimal getNh23() {
		return nh23;
	}

	/**
	 * @param nh23 the nh23 to set
	 */
	public void setNh23(BigDecimal nh23) {
		this.nh23 = nh23;
	}

	/**
	 * @return the nh24
	 */
	public BigDecimal getNh24() {
		return nh24;
	}

	/**
	 * @param nh24 the nh24 to set
	 */
	public void setNh24(BigDecimal nh24) {
		this.nh24 = nh24;
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
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public BigDecimal getH00() {
		return h00;
	}

	public void setH00(BigDecimal h00) {
		this.h00 = h00;
	}

	public BigDecimal getCh00() {
		return ch00;
	}

	public void setCh00(BigDecimal ch00) {
		this.ch00 = ch00;
	}

	public BigDecimal getOh00() {
		return oh00;
	}

	public void setOh00(BigDecimal oh00) {
		this.oh00 = oh00;
	}

	public BigDecimal getNh00() {
		return nh00;
	}

	public void setNh00(BigDecimal nh00) {
		this.nh00 = nh00;
	}

	public double getP00() {
		return p00;
	}

	public void setP00(double p00) {
		this.p00 = p00;
	}
	
	public BigDecimal getHbparams() {
		return hbparams;
	}

	public void setHbparams(BigDecimal hbparams) {
		this.hbparams = hbparams;
	}
	
	public int getHbcounts() {
		return hbcounts;
	}

	public void setHbcounts(int hbcounts) {
		this.hbcounts = hbcounts;
	}

	/**
	 * 重写equals方法，用于环比数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof DayReport) {
			DayReport dayReport = (DayReport) obj;
			String roadId = dayReport.getRoadId()==null?"":dayReport.getRoadId();
			String directCode = dayReport.getDirectCode();
			return (roadId.equals(this.roadId) && directCode.equals(this.directCode));
			
		}else{
			return false;
		}
			
	}
	
}
