package com.product.discount.management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    private String productId;

    private double productPrice;
    private int quantity;

    private double finalPrice;
    private boolean seasonalDiscountActive;
    private LocalDate seasonalStartDate;
    private LocalDate seasonalEndDate;

    private String discountType;
    private double discountValue;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public boolean isSeasonalDiscountActive() {
		return seasonalDiscountActive;
	}
	public void setSeasonalDiscountActive(boolean seasonalDiscountActive) {
		this.seasonalDiscountActive = seasonalDiscountActive;
	}
	public LocalDate getSeasonalStartDate() {
		return seasonalStartDate;
	}
	public void setSeasonalStartDate(LocalDate seasonalStartDate) {
		this.seasonalStartDate = seasonalStartDate;
	}
	public LocalDate getSeasonalEndDate() {
		return seasonalEndDate;
	}
	public void setSeasonalEndDate(LocalDate seasonalEndDate) {
		this.seasonalEndDate = seasonalEndDate;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public double getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

    
    
}
