package com.timeline.model.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "UserContribute")
public class UserContribute {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "DetailID")
    private Integer DetailID;

    @Column(name = "SubjectID")
    private Integer SubjectID;

    @Column(name = "UserID")
    private Integer UserID;

    @Column(name = "IsValid")
    private Integer IsValid;

    @Column(name = "CreateTime")
    private Timestamp CreateTime;

    @Column(name = "UpdateTime")
    private Timestamp UpdateTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getDetailID() {
        return DetailID;
    }

    public void setDetailID(Integer detailID) {
        DetailID = detailID;
    }

    public Integer getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(Integer subjectID) {
        SubjectID = subjectID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getIsValid() {
        return IsValid;
    }

    public void setIsValid(Integer isValid) {
        IsValid = isValid;
    }

    public Timestamp getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Timestamp createTime) {
        CreateTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        UpdateTime = updateTime;
    }
}
