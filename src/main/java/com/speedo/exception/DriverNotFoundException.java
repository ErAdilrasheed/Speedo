package com.speedo.speedo.exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message){
        super(message);
    }
}
