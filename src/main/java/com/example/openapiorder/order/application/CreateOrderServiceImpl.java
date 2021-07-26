package com.example.openapiorder.order.application;

import com.example.openapiorder.order.application.port.in.CreateOrderService;
import com.example.openapiorder.order.application.port.out.PendingOrderRepository;

public class CreateOrderServiceImpl implements CreateOrderService {
    public CreateOrderServiceImpl(PendingOrderRepository pendingOrderRepository) {
    }
}
