package com.nejlasahin.invoicemanagement.exceptions;

import com.nejlasahin.invoicemanagement.generic.BaseMessage;
import com.nejlasahin.invoicemanagement.generic.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends GenericException {
    public UserNotFoundException(BaseMessage message) {
        super(message);
    }
}
