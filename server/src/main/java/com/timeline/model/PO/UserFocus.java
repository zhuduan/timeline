package com.timeline.model.PO;

import java.util.Date;

public class UserFocus {
    private Integer ID;

    private Integer UserID;

    private Integer SubjectID;

    private Integer IsValid;

    private Date CreateTime;

    private Date UpdateTime;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public Integer getUserId() {
        return UserID;
    }

    public void setUserId(Integer userID) {
        UserID = userID;
    }

    public Integer getSubjectId() {
        return SubjectID;
    }

    public void setSubjectId(Integer subjectID) {
        SubjectID = subjectID;
    }

    public Integer getIsValid() {
        return IsValid;
    }

    public void setIsValid(Integer isValid) {
        IsValid = isValid;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }
}