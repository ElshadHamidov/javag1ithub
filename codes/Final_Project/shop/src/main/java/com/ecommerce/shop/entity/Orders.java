package com.ecommerce.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    private Integer user_id;
    private String status;
    private LocalDate date_placed;
    private String payment;
    private String address;
    private LocalDate estimated_delivery;
}