package com.timeline.common;

public enum EnumStatus {

    DEFAULT(0),
    EXCELLENT(1),
    HOT(2);

    private Integer statusID = 0;

    EnumStatus(Integer statusID){
        this.statusID = statusID;
    }
}
