package com.nejlasahin.invoicemanagement.converter;

import com.nejlasahin.invoicemanagement.dto.request.ProductRequestDto;
import com.nejlasahin.invoicemanagement.dto.response.ProductResponseDto;
import com.nejlasahin.invoicemanagement.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public static Product toProduct(ProductRequestDto request) {
        return Product.builder()
                .productName(request.getProductName())
                .build();
    }

    public static ProductResponseDto toProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .build();
    }

    public static List<ProductResponseDto> toProductResponseDtoList(List<Product> products) {
        if (products.isEmpty()) {
            return List.of();
        }
        return products.stream().map(ProductConverter::toProductResponseDto).collect(Collectors.toList());
    }
}
