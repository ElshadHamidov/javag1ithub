package com.ecommerce.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByUserId(Integer id);

	List<Product> findAllByOrderByPriceAsc();

	List<Product> findAllByOrderByPriceDesc();

}
