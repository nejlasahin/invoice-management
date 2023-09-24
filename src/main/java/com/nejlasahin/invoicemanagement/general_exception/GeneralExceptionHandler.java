package com.nejlasahin.invoicemanagement.general_exception;

import com.nejlasahin.invoicemanagement.exceptions.ProductAlreadyExists;
import com.nejlasahin.invoicemanagement.exceptions.ProductNotFoundException;
import com.nejlasahin.invoicemanagement.exceptions.UserInvalidPasswordException;
import com.nejlasahin.invoicemanagement.exceptions.UserInvalidTokenException;
import com.nejlasahin.invoicemanagement.exceptions.UserNotFoundException;
import com.nejlasahin.invoicemanagement.generic.BaseMessage;
import com.nejlasahin.invoicemanagement.generic.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllUserNotFoundException(UserNotFoundException ex, WebRequest webRequest) {

        BaseMessage message = ex.getBaseMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse response = new ExceptionResponse(description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(response, message);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllProductNotFoundException(ProductNotFoundException ex, WebRequest webRequest) {

        BaseMessage message = ex.getBaseMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse response = new ExceptionResponse(description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(response, message);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllUserInvalidPasswordException(UserInvalidPasswordException ex, WebRequest webRequest) {

        BaseMessage message = ex.getBaseMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse response = new ExceptionResponse(description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(response, message);

        return new ResponseEntity<>(restResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllProductAlreadyExists(ProductAlreadyExists ex, WebRequest webRequest) {

        BaseMessage message = ex.getBaseMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse response = new ExceptionResponse(description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(response, message);

        return new ResponseEntity<>(restResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllUserInvalidTokenException(UserInvalidTokenException ex, WebRequest webRequest) {

        BaseMessage message = ex.getBaseMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse response = new ExceptionResponse(description);

        RestResponse<ExceptionResponse> restResponse = RestResponse.error(response, message);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

}