package com.timeline.model.DTO;

import java.util.Date;

public class UserFocusDTO {
    private Integer ID;

    private Integer UserID;

    private Integer SubjectID;

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

}