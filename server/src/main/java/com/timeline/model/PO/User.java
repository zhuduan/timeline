package com.timeline.model.PO;

import java.util.Date;

public class User {
  private Integer ID;

  private String Name;

  private String PicUrl;

  private Byte Role;

  private Byte Authority;

  private String Email;

  private String Phone;

  private String password;

  private String WechatAccount;

  private String WeiboAccount;

  private String GoogleAccount;

  private Byte IsValid;

  private Date CreateTime;

  private Date UpdateTime;

  public Integer getId() {
    return ID;
  }

  public void setId(Integer ID) {
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

  public Byte getRole() {
    return Role;
  }

  public void setRole(Byte role) {
    Role = role;
  }

  public Byte getAuthority() {
    return Authority;
  }

  public void setAuthority(Byte authority) {
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}