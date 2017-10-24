package com.timeline.model.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class Detail {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "SubjectID", nullable = false)
    private Integer SubjectID;

    @Column(name = "Title", nullable = false)
    private String Title;

    @Column(name = "Content", nullable = false)
    private String Content;

    @Column(name = "PicUrl", nullable = false)
    private String PicUrl;

    @Column(name = "PicDes", nullable = false)
    private String PicDes;

    @Column(name = "AuthorID", nullable = false)
    private Integer AuthorID;

    @Column(name = "ContributorIDs", nullable = false)
    private String ContributorIDs;

    @Column(name = "OccurrenceTime", nullable = false)
    private Date OccurrenceTime;

    @Column(name = "Language", nullable = false)
    private Integer Language;

    @Column(name = "ReplyCount", nullable = false)
    private Integer ReplyCount;

    @Column(name = "LikeCount", nullable = false)
    private Integer LikeCount;

    @Column(name = "IsValid", nullable = false)
    private Integer IsValid;

    @Column(name = "CreateTime", nullable = false)
    private Timestamp CreateTime;

    @Column(name = "UpdateTime", nullable = false)
    private Timestamp UpdateTime;

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
