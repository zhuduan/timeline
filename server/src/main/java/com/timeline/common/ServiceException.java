package com.timeline.common;

public class ServiceException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4550115302234372986L;

	public ServiceException(ErrorType errorType){
        super(errorType.getErrorMsg());
    }
    
}
