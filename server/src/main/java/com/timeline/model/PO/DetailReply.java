package com.timeline.model.PO;

import java.util.Date;

public class DetailReply {
    private Integer ID;

    private Integer DetailID;

    private String Title;

    private String Content;

    private Integer AuthorID;

    private Byte IsValid;

    private Date CreateTime;

    private Date UpdateTime;

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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Integer getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(Integer authorID) {
        AuthorID = authorID;
    }

    public Byte getIsValid() {
        return IsValid;
    }

    public void setIsValid(Byte isValid) {
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

    public DetailReply() {
    }

    public DetailReply(Integer detailID, String title, String content, Integer authorID) {
        DetailID = detailID;
        Title = title;
        Content = content;
        AuthorID = authorID;
    }
}