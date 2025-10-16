package com.ecommerce.shop.repository;
import com.ecommerce.shop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByOrderId(String orderId);
}