package com.timeline.model.DTO;

import com.timeline.model.PO.Detail;

import java.util.Date;

public class DetailDTO {

    private Integer ID;

    private Integer SubjectID;

    private String Title;

    private String Content;

    private String PicUrl;

    private String PicDes;

    private Integer AuthorID;

    private String ContributorIDs;

    private Date OccurrenceTime;

    private Integer Language;

    private Integer ReplyCount;

    private Integer LikeCount;

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

    // this constructor will be replaced by common util
    @Deprecated()
    public DetailDTO(Detail po){
        this.setID(po.getId());
        this.setSubjectID(po.getSubjectID());
    }
}
