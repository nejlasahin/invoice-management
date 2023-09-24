package com.nejlasahin.invoicemanagement.service;

import com.nejlasahin.invoicemanagement.converter.ProductConverter;
import com.nejlasahin.invoicemanagement.dto.request.ProductRequestDto;
import com.nejlasahin.invoicemanagement.dto.response.ProductResponseDto;
import com.nejlasahin.invoicemanagement.entity.Product;
import com.nejlasahin.invoicemanagement.enumeration.ProductMessage;
import com.nejlasahin.invoicemanagement.exceptions.ProductAlreadyExists;
import com.nejlasahin.invoicemanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductConverter converter;

    public ProductResponseDto create(ProductRequestDto request) {
        repository.findByProductName(request.getProductName())
                .ifPresent(product -> {
                    throw new ProductAlreadyExists(ProductMessage.PRODUCT_ALREADY_EXISTS);
                });
        Product saveProduct = repository.save(ProductConverter.toProduct(request));
        return ProductConverter.toProductResponseDto(saveProduct);
    }

    public List<ProductResponseDto> getAll() {
        List<Product> products = repository.findAll();
        return ProductConverter.toProductResponseDtoList(products);
    }
}
