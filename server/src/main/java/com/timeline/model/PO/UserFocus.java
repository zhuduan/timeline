package com.timeline.model.PO;

import java.util.Date;

public class UserFocus {
    private Integer ID;

    private Integer UserID;

    private Integer SubjectID;

    private Integer IsValid;

    private Date CreateTime;

    private Date UpdateTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Integer subjectID) {
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