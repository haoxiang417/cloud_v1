package com.lec.common.user.vo;

import java.io.Serializable;
import java.util.Set;

import com.lec.common.system.vo.SystemResource;

public class Role implements Serializable{
	private static final long serialVersionUID = 262375790341475644L;

	private String id;

    private String code;

    private String name;

    private String memo;

    private String status;

    /***
     * 创建用户ID
     */
    private String createBy;
    
    Set<SystemResource> resources;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getStatus() {
        return status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public Set<SystemResource> getResources() {
		return resources;
	}

	public void setResources(Set<SystemResource> resources) {
		this.resources = resources;
	}
    
    
}