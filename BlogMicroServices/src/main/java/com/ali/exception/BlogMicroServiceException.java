package com.ali.exception;

import lombok.Getter;

@Getter
public class BlogMicroServiceException extends  RuntimeException{

    private final ErrorType errorType;

    public BlogMicroServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public BlogMicroServiceException(ErrorType errorType , String message){
        super(message);
        this.errorType=errorType;

    }

}
