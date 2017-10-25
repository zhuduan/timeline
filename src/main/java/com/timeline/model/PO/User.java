package com.timeline.model.PO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "PicUrl")
    private String PicUrl;

    @Column(name = "Role")
    private Integer Role;

    @Column(name = "Authority")
    private Integer Authority;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "WechatAccount")
    private String WechatAccount;

    @Column(name = "WeiboAccount")
    private String WeiboAccount;

    @Column(name = "GoogleAccount")
    private String GoogleAccount;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public Integer getRole() {
        return Role;
    }

    public void setRole(Integer role) {
        Role = role;
    }

    public Integer getAuthority() {
        return Authority;
    }

    public void setAuthority(Integer authority) {
        Authority = authority;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getWechatAccount() {
        return WechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        WechatAccount = wechatAccount;
    }

    public String getWeiboAccount() {
        return WeiboAccount;
    }

    public void setWeiboAccount(String weiboAccount) {
        WeiboAccount = weiboAccount;
    }

    public String getGoogleAccount() {
        return GoogleAccount;
    }

    public void setGoogleAccount(String googleAccount) {
        GoogleAccount = googleAccount;
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
