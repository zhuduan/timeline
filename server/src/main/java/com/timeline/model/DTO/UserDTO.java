package com.timeline.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {

  private Integer ID;

  private String Name;

  private String PicUrl;

  @JsonIgnore
  private Byte Role;

  @JsonIgnore
  private Byte Authority;

  @JsonIgnore
  private String password;

  @JsonIgnore
  private String Email;

  @JsonIgnore
  private String Phone;

  @JsonIgnore
  private String WechatAccount;

  @JsonIgnore
  private String WeiboAccount;

  @JsonIgnore
  private String GoogleAccount;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}