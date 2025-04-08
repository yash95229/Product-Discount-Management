package com.product.discount.management.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DiscountCalculator {

    public double calculateFinalPrice(double price, String type, double value, boolean isSeasonal, LocalDate start, LocalDate end) {
        double finalPrice = price;

        if ("percentage".equalsIgnoreCase(type)) {
            finalPrice -= (price * value / 100.0);
        } else if ("flat".equalsIgnoreCase(type)) {
            finalPrice -= value;
        } else {
            throw new IllegalArgumentException("Invalid discount type.");
        }

        // Seasonal logic
        if (isSeasonal && LocalDate.now().isAfter(start.minusDays(1)) && LocalDate.now().isBefore(end.plusDays(1))) {
            finalPrice -= (finalPrice * 0.25); // 25% seasonal
        }

        return Math.max(finalPrice, 0.0); 
    }
}
