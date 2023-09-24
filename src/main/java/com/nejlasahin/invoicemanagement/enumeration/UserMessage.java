package com.nejlasahin.invoicemanagement.enumeration;

import com.nejlasahin.invoicemanagement.generic.BaseMessage;

public enum UserMessage implements BaseMessage {
    SUCCESS("SUCCESS"),
    INVALID_PASSWORD("Invalid password!"),
    INVALID_TOKEN("Invalid token!"),
    USER_NOT_FOUND("User not found!");

    private String message;

    UserMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
