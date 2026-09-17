package com.savoira.assessment;

public class AboveMaximumException extends RuntimeException {
    public AboveMaximumException(String message) {
        super(message);
    }
}