package com.Ankit.DunzoCarrier.repository;

import com.Ankit.DunzoCarrier.Entity.Order.CreateOrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreateOrderRequestRepo extends JpaRepository<CreateOrderRequest,Long> {
    Optional<CreateOrderRequest> findByOrderId(String orderId);
}
