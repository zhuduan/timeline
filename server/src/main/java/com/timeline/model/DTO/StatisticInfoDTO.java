package com.timeline.model.DTO;

import java.util.Date;

public class StatisticInfoDTO {

  private Integer ID;

  private String RequestUrl;

  private Integer RequestUserID;

  private String RequestIP;

  private Date RequestDateTime;

  public Integer getID() {
    return ID;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public String getRequestUrl() {
    return RequestUrl;
  }

  public void setRequestUrl(String requestUrl) {
    RequestUrl = requestUrl;
  }

  public Integer getRequestUserID() {
    return RequestUserID;
  }

  public void setRequestUserID(Integer requestUserID) {
    RequestUserID = requestUserID;
  }

  public String getRequestIP() {
    return RequestIP;
  }

  public void setRequestIP(String requestIP) {
    RequestIP = requestIP;
  }

  public Date getRequestDateTime() {
    return RequestDateTime;
  }

  public void setRequestDateTime(Date requestDateTime) {
    RequestDateTime = requestDateTime;
  }
}
