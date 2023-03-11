package com.ali.exception;

import lombok.Getter;

@Getter
public class AuthMicroServiceException extends  RuntimeException{

    private final ErrorType errorType;

    public AuthMicroServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public AuthMicroServiceException(ErrorType errorType , String message){
        super(message);
        this.errorType=errorType;

    }

}
