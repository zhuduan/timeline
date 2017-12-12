package com.timeline.common;

public enum EnumAction {
    REPLY_ADD(1000,"add reply"),
    REPLY_UPDATE(1001, "update reply"),
    REPLY_DELETE(1002, "delete reply");

    private Integer actionID = 0;

    private String actionName = "default";

    EnumAction(Integer actionID, String actionName) {
        this.actionID = actionID;
        this.actionName = actionName;
    }

    public Integer getActionID() {
        return actionID;
    }

    public void setActionID(Integer actionID) {
        this.actionID = actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
