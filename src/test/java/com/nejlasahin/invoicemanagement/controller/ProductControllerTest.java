package com.nejlasahin.invoicemanagement.controller;

import com.nejlasahin.invoicemanagement.dto.request.ProductRequestDto;
import com.nejlasahin.invoicemanagement.dto.response.ProductResponseDto;
import com.nejlasahin.invoicemanagement.generic.RestResponse;
import com.nejlasahin.invoicemanagement.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @Test
    public void create() {
        ProductRequestDto request = new ProductRequestDto("TR777");
        ProductResponseDto response = new ProductResponseDto(7L, "TR777");
        when(productService.create(request )).thenReturn(response);

        ResponseEntity<RestResponse<ProductResponseDto>> actual = productController.create(request);

        assertAll(
                () -> assertNotNull(actual.getBody()),
                () -> assertEquals(request.getProductName(), actual.getBody().getData().getProductName()),
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK)
        );
    }

    @Test
    public void getAll() {
        List<ProductResponseDto> responseList = List.of(new ProductResponseDto(7L, "TR777"), new ProductResponseDto(8L, "TR888"));
        when(productService.getAll()).thenReturn(responseList);

        ResponseEntity<RestResponse<List<ProductResponseDto>>> actual = productController.getAll();

        assertAll(
                () -> assertNotNull(actual.getBody()),
                () -> assertEquals(responseList.size(), actual.getBody().getData().size()),
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK)
        );
    }
}
