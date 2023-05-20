package com.una.carassiststorebackend.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String id;
    private String productId;
    private BigDecimal totalPrice;
    private Date date;
    private String paymentType;

    public Order() { super(); }

    public Order(BigDecimal totalPrice, Date date, String paymentType) {
        super();
        this.totalPrice = totalPrice;
        this.date = date;
        this.paymentType = paymentType;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
