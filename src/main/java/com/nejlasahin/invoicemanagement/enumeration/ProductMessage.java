package com.nejlasahin.invoicemanagement.enumeration;

import com.nejlasahin.invoicemanagement.generic.BaseMessage;

public enum ProductMessage implements BaseMessage {
    SUCCESS("SUCCESS"),
    PRODUCT_ALREADY_EXISTS("Product already exists!"),
    PRODUCT_NOT_FOUND("Product not found!");

    private String message;

    ProductMessage(String message) {
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
