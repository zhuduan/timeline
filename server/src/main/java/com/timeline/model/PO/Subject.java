package com.timeline.model.PO;

import java.util.Date;

public class Subject {
    private Integer ID;

    private String Title;

    private String PicUrl;

    private String PicDes;

    private Integer AuthorID;

    private String ContributorIDs;

    private String Category;

    private String Tags;

    private Date StartTime;

    private Date EndTime;

    private Integer Language;

    private String RelatedSubjectIDs;

    private Byte IsValid;

    private Date CreateTime;

    private Date UpdateTime;

    private String Content;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public Integer getAuthorId() {
        return AuthorID;
    }

    public void setAuthorId(Integer authorID) {
        AuthorID = authorID;
    }

    public String getContributorIds() {
        return ContributorIDs;
    }

    public void setContributorIds(String contributorIDs) {
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

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public Integer getLanguage() {
        return Language;
    }

    public void setLanguage(Integer language) {
        Language = language;
    }

    public String getRelatedSubjectIds() {
        return RelatedSubjectIDs;
    }

    public void setRelatedSubjectIds(String relatedSubjectIDs) {
        RelatedSubjectIDs = relatedSubjectIDs;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}