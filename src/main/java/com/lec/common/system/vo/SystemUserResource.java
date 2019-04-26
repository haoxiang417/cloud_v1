package com.lec.common.system.vo;

public class SystemUserResource implements java.io.Serializable {

	private static final long serialVersionUID = -3754094411614329593L;

	public SystemUserResource() {}
	public SystemUserResource(String userId, String resourceId, Integer sortNum) {
		this.userId = userId;
		this.resourceId = resourceId;
		this.sortNum = sortNum;
	}
	
	private String userId;
	private String resourceId;
	private Integer sortNum;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
}
