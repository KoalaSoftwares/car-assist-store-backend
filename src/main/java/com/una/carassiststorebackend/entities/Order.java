package com.una.carassiststorebackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private BigDecimal totalPrice;

    @Column
    private Date date;

    @NotBlank
    @Column
    private String paymentType;

    @NotBlank
    @Column
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    public Order() { super(); }

    public Order(BigDecimal totalPrice, Date date, String paymentType, String userName, Set<Product> products) {
        super();
        this.totalPrice = totalPrice;
        this.date = date;
        this.paymentType = paymentType;
        this.userName = userName;
        this.products = products;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(totalPrice, order.totalPrice) && Objects.equals(date, order.date) && Objects.equals(paymentType, order.paymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, date, paymentType);
    }
}
