package com.una.carassiststorebackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column
    private String productId;

    @Column
    private BigDecimal totalPrice;

    @Column
    private Date date;

    @NotBlank
    @Column
    private String paymentType;

    public Order() { super(); }

    public Order(String productId, BigDecimal totalPrice, Date date, String paymentType) {
        super();
        this.productId = productId;
        this.totalPrice = totalPrice;
        this.date = date;
        this.paymentType = paymentType;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(productId, order.productId) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(date, order.date) && Objects.equals(paymentType, order.paymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, totalPrice, date, paymentType);
    }
}
