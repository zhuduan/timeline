package com.timeline.model.PO;

import java.util.Date;

public class UserContribute {
  private Integer ID;

  private Integer SubjectID;

  private Integer DetailID;

  private Integer UserID;

  private Integer IsValid;

  private Date CreateTime;

  private Date UpdateTime;

  public Integer getId() {
    return ID;
  }

  public void setId(Integer ID) {
    this.ID = ID;
  }

  public Integer getSubjectId() {
    return SubjectID;
  }

  public void setSubjectId(Integer subjectID) {
    SubjectID = subjectID;
  }

  public Integer getDetailId() {
    return DetailID;
  }

  public void setDetailId(Integer detailID) {
    DetailID = detailID;
  }

  public Integer getUserId() {
    return UserID;
  }

  public void setUserId(Integer userID) {
    UserID = userID;
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