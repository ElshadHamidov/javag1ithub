package com.ecommerce.shop.controller;

import com.ecommerce.shop.entity.Orders;
import com.ecommerce.shop.repository.OrdersRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // allow frontend access
@RestController
@RequestMapping("/api/order")
public class OrdersController {

    private final OrdersRepository ordersRepo;

    public OrdersController(OrdersRepository ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    @GetMapping("/{orderId}")
    public Orders getOrder(@PathVariable String orderId) {
        return ordersRepo.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}