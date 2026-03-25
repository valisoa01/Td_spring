package com.tdspring.controller;

public class BadRequestException extends RuntimeException {
    public  BadRequestException(String message) {
        super(message);
    }
}
