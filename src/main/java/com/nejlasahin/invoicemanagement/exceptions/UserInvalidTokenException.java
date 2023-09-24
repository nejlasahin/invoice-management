package com.nejlasahin.invoicemanagement.exceptions;

import com.nejlasahin.invoicemanagement.generic.BaseMessage;
import com.nejlasahin.invoicemanagement.generic.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserInvalidTokenException extends GenericException {
    public UserInvalidTokenException(BaseMessage message) {
        super(message);
    }
}