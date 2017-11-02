package com.timeline.common;

public class ServiceException extends Exception {

    public ServiceException(ErrorType errorType){
        super(errorType.getErrorMsg());
    }
    
}
