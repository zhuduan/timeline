package com.timeline.model.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "SubjectPO")
public class SubjectPO {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Content")
    private String Content;

    @Column(name = "PicUrl")
    private String PicUrl;

    @Column(name = "PicDes")
    private String PicDes;

    @Column(name = "AuthorID")
    private Integer AuthorID;

    @Column(name = "ContributorIDs")
    private String ContributorIDs;

    @Column(name = "Category")
    private String Category;

    @Column(name = "Tags")
    private String Tags;

    @Column(name = "StartTime")
    private Date StartTime;

    @Column(name = "EndTime")
    private Date EndTime;

    @Column(name = "Language")
    private Integer Language;

    @Column(name = "RelatedSubjectIDs")
    private String RelatedSubjectIDs;

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

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getPicDes() {
        return PicDes;
    }

    public void setPicDes(String picDes) {
        PicDes = picDes;
    }

    public Integer getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(Integer authorID) {
        AuthorID = authorID;
    }

    public String getContributorIDs() {
        return ContributorIDs;
    }

    public void setContributorIDs(String contributorIDs) {
        ContributorIDs = contributorIDs;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
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
