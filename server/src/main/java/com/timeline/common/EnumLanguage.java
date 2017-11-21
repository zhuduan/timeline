package com.timeline.common;

import io.swagger.models.auth.In;

public enum EnumLanguage {

    CN(1),       // zh_ch: chinese
    EN(2);       // english

    private Integer languageID = 0;

    EnumLanguage(Integer languageID){
        this.languageID = languageID;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    /***
     *  to check if the input id is a valid id
     *
     * @param languageID
     * @return
     */
    public static Boolean isValid(Integer languageID){
        for ( EnumLanguage language : values() ){
            if ( language.getLanguageID().equals(languageID) ){
                return true;
            }
        }
        return false;
    }
}
