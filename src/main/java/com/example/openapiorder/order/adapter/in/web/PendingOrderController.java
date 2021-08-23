package com.example.openapiorder.order.adapter.in.web;

import com.example.openapiorder.order.application.port.in.CreateOrderService;
import com.example.openapiorder.order.application.port.in.GetPendingOrderService;
import com.example.openapiorder.order.domain.PendingOrder;
import io.tej.SwaggerCodgen.api.OrdersApi;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;
import io.tej.SwaggerCodgen.model.PendingOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PendingOrderController implements OrdersApi  {
    private final CreateOrderService createOrderService;
    private final GetPendingOrderService getPendingOrderService;

    public PendingOrderController(CreateOrderService createOrderService, GetPendingOrderService getPendingOrderService) {
        this.createOrderService = createOrderService;
        this.getPendingOrderService = getPendingOrderService;
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

    @Override
    public ResponseEntity<PendingOrderResponse> getPendingOrderById(Long id) {
        PendingOrder pendingOrder = getPendingOrderService.getPendingOrder(id);
        PendingOrderResponse response = new PendingOrderResponse()
                .id(pendingOrder.getId())
                .productId(pendingOrder.getProductId())
                .quantity(pendingOrder.getQuantity());
        return ResponseEntity.ok(response);
    }
}