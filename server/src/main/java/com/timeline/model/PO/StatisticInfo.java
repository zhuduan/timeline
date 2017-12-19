package com.timeline.model.PO;

import java.util.Date;

public class StatisticInfo {

    private Integer ID;

    private String RequestUrl;

    private Integer RequestUserID;

    private String RequestIP;

    private Date RequestDateTime;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public String getRequestUrl() {
        return RequestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        RequestUrl = requestUrl;
    }

    public Integer getRequestUserId() {
        return RequestUserID;
    }

    public void setRequestUserId(Integer requestUserID) {
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
