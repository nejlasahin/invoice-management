package com.nejlasahin.invoicemanagement.controller;

import com.nejlasahin.invoicemanagement.dto.request.ProductRequestDto;
import com.nejlasahin.invoicemanagement.enumeration.ProductMessage;
import com.nejlasahin.invoicemanagement.generic.RestResponse;
import com.nejlasahin.invoicemanagement.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@SecurityRequirement(name = "in-memory")
@Tag(name = "Product", description = "Endpoints for managing product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ProductRequestDto request) {
        return new ResponseEntity<>(RestResponse.of(productService.create(request), ProductMessage.SUCCESS), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return new ResponseEntity<>(RestResponse.of(productService.getAll(), ProductMessage.SUCCESS), HttpStatus.OK);
    }
}
