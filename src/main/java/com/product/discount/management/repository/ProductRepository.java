package com.product.discount.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.discount.management.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
