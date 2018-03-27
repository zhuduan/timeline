package com.timeline.model.DTO;

public class UserContributeDTO {
  private Integer ID;

  private Integer SubjectID;

  private Integer DetailID;

  private Integer UserID;

  public Integer getID() {
    return ID;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public Integer getSubjectID() {
    return SubjectID;
  }

  public void setSubjectID(Integer subjectID) {
    SubjectID = subjectID;
  }

  public Integer getDetailID() {
    return DetailID;
  }

  public void setDetailID(Integer detailID) {
    DetailID = detailID;
  }

  public Integer getUserID() {
    return UserID;
  }

  public void setUserID(Integer userID) {
    UserID = userID;
  }
}