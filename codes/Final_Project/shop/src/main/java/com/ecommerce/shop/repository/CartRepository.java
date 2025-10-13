package com.ecommerce.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByUserId(Integer id);

}
