package com.nejlasahin.invoicemanagement.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> implements Serializable {

    private T data;
    private Date responseDate;
    private boolean isSuccess;
    private BaseMessage message;

    public RestResponse(T data, boolean isSuccess, BaseMessage message) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.message = message;
        responseDate = new Date();
    }

    public static <T> RestResponse<T> of(T t, BaseMessage message) {
        return new RestResponse<>(t, true, message);
    }

    public static <T> RestResponse<T> error(T t, BaseMessage message) {
        return new RestResponse<>(t, false, message);
    }

    public static <T> RestResponse<T> empty(BaseMessage message) {
        return new RestResponse<>(null, true, message);
    }
}