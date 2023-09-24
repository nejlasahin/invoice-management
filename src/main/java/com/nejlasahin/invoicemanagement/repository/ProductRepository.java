package com.nejlasahin.invoicemanagement.repository;

import com.nejlasahin.invoicemanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);

    Optional<Product> findById(Long productId);
}
