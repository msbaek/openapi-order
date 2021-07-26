package com.example.openapiorder.order.adapter.in.web;

import com.example.openapiorder.order.application.port.in.CreateOrderService;
import com.example.openapiorder.order.domain.PendingOrder;
import io.tej.SwaggerCodgen.api.OrdersApi;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;
import io.tej.SwaggerCodgen.model.PendingOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrdersApi  {
    private final CreateOrderService createOrderService;

    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @Override
    public ResponseEntity<PendingOrderResponse> createPendingOrder(PendingOrderRequest pendingOrderRequest) {
        PendingOrder pendingOrder = createOrderService.createPendingOrder(pendingOrderRequest);
        PendingOrderResponse response = new PendingOrderResponse()
                .id(pendingOrder.getId())
                .productId(pendingOrder.getProductId())
                .quantity(pendingOrder.getQuantity())
                ;
        return ResponseEntity.ok(response);
    }
}