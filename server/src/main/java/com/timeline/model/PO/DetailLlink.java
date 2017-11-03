package com.timeline.model.PO;

import java.util.Date;

public class DetailLlink {
    private Integer ID;

    private String DetailID_Language;

    private String Title;

    private String PicUrl;

    private String PicDes;

    private String SourceName;

    private String SourceLink;

    private Integer Weight;

    private Integer Status;

    private Integer IsValid;

    private Date CreateTime;

    private Date UpdateTime;

    private String Content;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDetailID_Language() {
        return DetailID_Language;
    }

    public void setDetailID_Language(String detailID_Language) {
        DetailID_Language = detailID_Language;
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

    public String getSourceName() {
        return SourceName;
    }

    public void setSourceName(String sourceName) {
        SourceName = sourceName;
    }

    public String getSourceLink() {
        return SourceLink;
    }

    public void setSourceLink(String sourceLink) {
        SourceLink = sourceLink;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}