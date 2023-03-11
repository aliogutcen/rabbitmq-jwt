package com.exception;

import lombok.Getter;

@Getter
public class MailMicroServiceException extends  RuntimeException{

    private final ErrorType errorType;

    public MailMicroServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public MailMicroServiceException(ErrorType errorType , String message){
        super(message);
        this.errorType=errorType;

    }

}
