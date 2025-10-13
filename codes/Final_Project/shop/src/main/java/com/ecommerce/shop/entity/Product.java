package com.ecommerce.shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String image;

    private Integer userId;

    private String category; 

    private Double rating;  
}

