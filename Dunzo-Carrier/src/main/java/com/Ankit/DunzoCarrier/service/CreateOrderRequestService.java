package com.Ankit.DunzoCarrier.service;

import com.Ankit.DunzoCarrier.Entity.Order.CreateOrderRequest;
import com.Ankit.DunzoCarrier.repository.CreateOrderRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateOrderRequestService {
    @Autowired
    CreateOrderRequestRepo createOrderRequestRepo;
    public void saveOrder(CreateOrderRequest request) {
        createOrderRequestRepo.save(request);
    }

    public Optional<CreateOrderRequest> getorderById(String orderId) {
      return  createOrderRequestRepo.findByOrderId(orderId);
    }
}
