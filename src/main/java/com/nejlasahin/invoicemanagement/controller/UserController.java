package com.nejlasahin.invoicemanagement.controller;

import com.nejlasahin.invoicemanagement.dto.request.UserRequestDto;
import com.nejlasahin.invoicemanagement.enumeration.UserMessage;
import com.nejlasahin.invoicemanagement.generic.RestResponse;
import com.nejlasahin.invoicemanagement.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "Endpoints for managing user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequestDto request) {
        return new ResponseEntity<>(RestResponse.of(userService.login(request), UserMessage.SUCCESS), HttpStatus.OK);
    }
}
