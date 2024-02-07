package com.usman.ems.exception;

public class ResponseNotFoundException extends RuntimeException{
    public ResponseNotFoundException(String message){
        super(message);
    }
}
