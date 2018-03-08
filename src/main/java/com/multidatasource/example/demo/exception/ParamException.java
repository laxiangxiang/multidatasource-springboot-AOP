package com.multidatasource.example.demo.exception;

public class ParamException extends RuntimeException{
    public ParamException(){
        super();
    }

    public ParamException(String message){
        super(message);
    }

    public ParamException(String message,Throwable cause){
        super(message,cause);
    }

    protected ParamException(String message,Throwable cause,boolean enableSuppression,boolean writableStaclTrace){
        super(message,cause,enableSuppression,writableStaclTrace);
    }
}
