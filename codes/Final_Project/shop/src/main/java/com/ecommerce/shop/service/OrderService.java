package com.ecommerce.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shop.entity.Cart;
import com.ecommerce.shop.entity.Order;
import com.ecommerce.shop.exception.OurRuntimeException;
import com.ecommerce.shop.repository.CartRepository;
import com.ecommerce.shop.repository.OrderRepository;
import com.ecommerce.shop.requestDto.OrderRequestDto;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public void order(OrderRequestDto dto) {
		
		Order order = new Order();
		order.setFirstName(dto.getFirstName());
		order.setLastName(dto.getLastName());
		order.setCountry(dto.getCountry());
		order.setAddress(dto.getAddress());
		order.setCity(dto.getCity());
		order.setPhone(dto.getPhone());
		order.setEmail(dto.getEmail());
		order.setCartNumber(dto.getCartNumber());
		order.setExpiryDate(dto.getExpiryDate());
		order.setZipCode(dto.getZipCode());
		orderRepository.save(order);
	}

	
}
