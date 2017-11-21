package com.timeline.util;

public class NumberUtil {

    public static boolean isPositiveAndValid(Integer inputInteger){
        if ( inputInteger!=null && inputInteger.intValue()>0 ){
            return true;
        }
        return false;
    }

}
