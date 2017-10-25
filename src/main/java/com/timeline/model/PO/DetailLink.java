package com.timeline.model.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "DetailLink")
public class DetailLink {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "DetailID_Language", nullable = false)
    private String DetailID_Language;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Content")
    private String Content;

    @Column(name = "PicUrl")
    private String PicUrl;

    @Column(name = "PicDes")
    private String PicDes;

    @Column(name = "SourceName")
    private String SourceName;

    @Column(name = "SourceLink")
    private String SourceLink;

    @Column(name = "Weight")
    private Integer Weight;

    @Column(name = "Status")
    private Integer Status;

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
