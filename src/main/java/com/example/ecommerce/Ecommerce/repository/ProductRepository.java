package com.example.ecommerce.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.Ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // You can add custom queries here if needed
}
