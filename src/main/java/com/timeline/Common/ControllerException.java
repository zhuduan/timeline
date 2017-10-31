package com.timeline.Common;


public class ControllerException extends Exception{

    public ControllerException(ErrorType errorType){
        super(errorType.getErrorMsg());
    }

}
