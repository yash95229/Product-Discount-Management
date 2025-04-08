package com.product.discount.management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.discount.management.dto.DiscountRequestDTO;
import com.product.discount.management.model.Product;
import com.product.discount.management.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/discount")
    public Product applyDiscount(@RequestBody DiscountRequestDTO dto) {
        return service.applyDiscount(dto);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return service.getProduct(productId);
    }
}
