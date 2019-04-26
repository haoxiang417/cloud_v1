package com.lec.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * 挖占类型报表数据封装类
 * @author guikaiping
 */
public class OccupyTypeReport implements Serializable{
	
	private static final long serialVersionUID = -3463723937557721045L;
	
	
	/***
	 * 道路名称
	 */
	private String roadId;
	/***
	 * 一周的总和
	 */
	private BigDecimal totals;
	
	//总数
	private int counts;
	//挖占类型名称
	private String[] typeNames;
	//挖占类型统计数
	private BigDecimal[] occupyTypeCounts;
	//审批数
	private BigDecimal approveCounts;
	//申请数
	private BigDecimal applyCounts;
	//结项数
	private BigDecimal finishCounts;
	//新增数
	private BigDecimal addCounts;

	
	public BigDecimal getOccupyResultTotals(){
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < occupyTypeCounts.length; i++) {
			result= result.add(occupyTypeCounts[i]==null?new BigDecimal(0):occupyTypeCounts[i]);
		}
		return result;
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
	 * @return the occupyTypeCounts
	 */
	public BigDecimal[] getOccupyTypeCounts() {
		return occupyTypeCounts;
	}


	/**
	 * @param occupyTypeCounts the occupyTypeCounts to set
	 */
	public void setOccupyTypeCounts(BigDecimal[] occupyTypeCounts) {
		this.occupyTypeCounts = occupyTypeCounts;
	}


	/**
	 * 重写equals方法，用于环比数据的比较
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof OccupyTypeReport) {
			OccupyTypeReport occupyTypeReport = (OccupyTypeReport) obj;
			String roadId = occupyTypeReport.getRoadId()==null?"":occupyTypeReport.getRoadId();
			return (roadId.equals(this.roadId));
		}else{
			return false;
		}
			
	}


	/**
	 * @return the approveCounts
	 */
	public BigDecimal getApproveCounts() {
		return approveCounts;
	}


	/**
	 * @param approveCounts the approveCounts to set
	 */
	public void setApproveCounts(BigDecimal approveCounts) {
		this.approveCounts = approveCounts;
	}


	/**
	 * @return the applyCounts
	 */
	public BigDecimal getApplyCounts() {
		return applyCounts;
	}


	/**
	 * @param applyCounts the applyCounts to set
	 */
	public void setApplyCounts(BigDecimal applyCounts) {
		this.applyCounts = applyCounts;
	}


	/**
	 * @return the finishCounts
	 */
	public BigDecimal getFinishCounts() {
		return finishCounts;
	}


	/**
	 * @param finishCounts the finishCounts to set
	 */
	public void setFinishCounts(BigDecimal finishCounts) {
		this.finishCounts = finishCounts;
	}


	/**
	 * @return the addCounts
	 */
	public BigDecimal getAddCounts() {
		return addCounts;
	}


	/**
	 * @param addCounts the addCounts to set
	 */
	public void setAddCounts(BigDecimal addCounts) {
		this.addCounts = addCounts;
	}
	
	
}
