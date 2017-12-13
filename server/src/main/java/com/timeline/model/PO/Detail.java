package com.timeline.model.PO;

import java.util.Date;

public class Detail {

    private Integer ID;

    private Integer SubjectID;

    private String Title;

    private String PicUrl;

    private String PicDes;

    private Integer AuthorID;

    private String ContributorIDs;

    private Date OccurrenceTime;

    private Integer Language;

    private Integer ReplyCount;

    private Integer LikeCount;

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

    public Integer getSubjectId() {
        return SubjectID;
    }

    public void setSubjectId(Integer subjectID) {
        SubjectID = subjectID;
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

    public Date getOccurrenceTime() {
        return OccurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        OccurrenceTime = occurrenceTime;
    }

    public Integer getLanguage() {
        return Language;
    }

    public void setLanguage(Integer language) {
        Language = language;
    }

    public Integer getReplyCount() {
        return ReplyCount;
    }

    public void setReplyCount(Integer replyCount) {
        ReplyCount = replyCount;
    }

    public Integer getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(Integer likeCount) {
        LikeCount = likeCount;
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