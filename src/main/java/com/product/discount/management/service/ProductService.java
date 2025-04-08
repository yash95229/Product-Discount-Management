package com.product.discount.management.service;

import com.product.discount.management.dto.DiscountRequestDTO;
import com.product.discount.management.exception.OutOfStockException;
import com.product.discount.management.model.Product;
import com.product.discount.management.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    @Autowired
    private DiscountCalculator calculator;

    public Product applyDiscount(DiscountRequestDTO dto) {
        if (dto.quantity <= 0) {
            log.warn("Attempt to add product [{}] failed: Quantity is 0", dto.productId);
            throw new OutOfStockException("Product is out of stock.");
        }

        LocalDate start = LocalDate.now().minusDays(5);
        LocalDate end = LocalDate.now().plusDays(5);

        double finalPrice = calculator.calculateFinalPrice(
                dto.productPrice,
                dto.discountType,
                dto.discountValue,
                dto.seasonalDiscountActive,
                start,
                end
        );

        Product product = new Product();
        product.setProductId(dto.productId);
        product.setProductPrice(dto.productPrice);
        product.setQuantity(dto.quantity);
        product.setDiscountType(dto.discountType);
        product.setDiscountValue(dto.discountValue);
        product.setSeasonalDiscountActive(dto.seasonalDiscountActive);
        product.setFinalPrice(finalPrice);
        product.setSeasonalStartDate(start);
        product.setSeasonalEndDate(end);

        Product savedProduct = repository.save(product);

     
        log.info(" Product [{}] added successfully!", dto.productId);
        log.info(" Original Price: ₹{} | Discount Type: {} | Discount Value: {}",
                dto.productPrice,
                dto.discountType,
                dto.discountValue
        );
        if (dto.seasonalDiscountActive) {
            log.info(" Seasonal Discount Applied: 25% ({} to {})", start, end);
        }
        log.info("Final Price after all discounts: ₹{}", finalPrice);

        return savedProduct;
    }

    public Product getProduct(String productId) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found."));
        log.info("Fetched Product [{}]: Final Price ₹{}", productId, product.getFinalPrice());
        return product;
    }
}
