package com.example.openapiorder.order.application;

import com.example.openapiorder.order.application.port.in.CreateOrderService;
import com.example.openapiorder.order.application.port.out.PendingOrderRepository;
import com.example.openapiorder.order.domain.PendingOrder;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;
import org.springframework.stereotype.Service;

@Service
class CreateOrderServiceImpl implements CreateOrderService {
    private final PendingOrderRepository pendingOrderRepository;

    CreateOrderServiceImpl(PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = PendingOrder.create(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }
}
