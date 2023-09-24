package com.nejlasahin.invoicemanagement.exceptions;

import com.nejlasahin.invoicemanagement.generic.BaseMessage;
import com.nejlasahin.invoicemanagement.generic.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductAlreadyExists extends GenericException {
    public ProductAlreadyExists(BaseMessage message) {
        super(message);
    }
}
