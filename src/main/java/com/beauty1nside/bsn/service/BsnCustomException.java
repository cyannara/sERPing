package com.beauty1nside.bsn.service;

public class BsnCustomException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    public BsnCustomException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}