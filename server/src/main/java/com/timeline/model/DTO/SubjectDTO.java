package com.timeline.model.DTO;

import java.util.Date;
import java.util.List;

public class SubjectDTO {
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

    private String Content;

    private List<DetailDTO> details;
    
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

    public String getRelatedSubjectIDs() {
        return RelatedSubjectIDs;
    }

    public void setRelatedSubjectIDs(String relatedSubjectIDs) {
        RelatedSubjectIDs = relatedSubjectIDs;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

	public List<DetailDTO> getDetails() {
		return details;
	}

	public void setDetails(List<DetailDTO> details) {
		this.details = details;
	}
}