package com.ecommerce.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
