package com.lec.common.deptment.vo;

import java.io.Serializable;

public class Department implements Serializable{
	private static final long serialVersionUID = 8022960857990607824L;

	/**
     * 
     */
    private String id;

    /**
     * 
     */
    private String parentid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String memo;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Integer levels;

    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private String principal;

    /**
     * 
     */
    private String mobile;

    /**
     * 
     */
    private String principalname;

    /**
     * 是否公司
     */
    private String isCorpor;

    /**
     * 公司id
     */
    private Long corporId;

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
     * @return the value of PARENTID
     */
    public String getParentid() {
        return parentid;
    }

    /**
    
     *
     * @param parentid the value for PARENTID
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
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
     * @return the value of MEMO
     */
    public String getMemo() {
        return memo;
    }

    /**
    
     *
     * @param memo the value for MEMO
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    /**
     * @return the value of LEVELS
     */
    public Integer getLevels() {
        return levels;
    }

    /**
    
     *
     * @param levels the value for LEVELS
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
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
     * @return the value of PRINCIPAL
     */
    public String getPrincipal() {
        return principal;
    }

    /**
    
     *
     * @param principal the value for PRINCIPAL
     */
    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    /**
     * @return the value of MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
    
     *
     * @param mobile the value for MOBILE
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * @return the value of PRINCIPALNAME
     */
    public String getPrincipalname() {
        return principalname;
    }

    /**
    
     *
     * @param principalname the value for PRINCIPALNAME
     */
    public void setPrincipalname(String principalname) {
        this.principalname = principalname == null ? null : principalname.trim();
    }

    /**
     * @return the value of IS_CORPOR
     */
    public String getIsCorpor() {
        return isCorpor;
    }

    /**
    
     *
     * @param isCorpor the value for IS_CORPOR
     */
    public void setIsCorpor(String isCorpor) {
        this.isCorpor = isCorpor == null ? null : isCorpor.trim();
    }

    /**
     * @return the value of CORPOR_ID
     */
    public Long getCorporId() {
        return corporId;
    }

    /**
    
     *
     * @param corporId the value for CORPOR_ID
     */
    public void setCorporId(Long corporId) {
        this.corporId = corporId;
    }

    /**
    
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentid=").append(parentid);
        sb.append(", name=").append(name);
        sb.append(", memo=").append(memo);
        sb.append(", status=").append(status);
        sb.append(", levels=").append(levels);
        sb.append(", code=").append(code);
        sb.append(", principal=").append(principal);
        sb.append(", mobile=").append(mobile);
        sb.append(", principalname=").append(principalname);
        sb.append(", isCorpor=").append(isCorpor);
        sb.append(", corporId=").append(corporId);
        sb.append("]");
        return sb.toString();
    }
}