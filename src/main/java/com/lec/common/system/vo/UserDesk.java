package com.lec.common.system.vo;

public class UserDesk {
    private String id;

    
    private String userId;

    private String resourceId;

    private String screennum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getScreennum() {
        return screennum;
    }

    public void setScreennum(String screennum) {
        this.screennum = screennum == null ? null : screennum.trim();
    }
}