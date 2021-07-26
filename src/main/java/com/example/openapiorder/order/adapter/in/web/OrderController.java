package com.example.openapiorder.order.adapter.in.web;

import io.tej.SwaggerCodgen.api.OrdersApi;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;
import io.tej.SwaggerCodgen.model.PendingOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrdersApi  {
    @Override
    public ResponseEntity<PendingOrderResponse> createPendingOrder(PendingOrderRequest pendingOrderRequest) {
        PendingOrderResponse response = new PendingOrderResponse()
                .productId(pendingOrderRequest.getProductId())
                .quantity(pendingOrderRequest.getQuantity())
                ;
        return ResponseEntity.ok(response);
    }
}