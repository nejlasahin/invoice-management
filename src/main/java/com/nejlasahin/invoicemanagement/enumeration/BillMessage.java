package com.nejlasahin.invoicemanagement.enumeration;

import com.nejlasahin.invoicemanagement.generic.BaseMessage;

public enum BillMessage implements BaseMessage {
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private String message;

    BillMessage(String message) {
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
