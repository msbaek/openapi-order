package com.example.openapiorder.order.application;

import com.example.openapiorder.order.adapter.out.persistence.PendingOrderRepositoryMemoryImpl;
import com.example.openapiorder.order.application.port.in.CreateOrderService;
import com.example.openapiorder.order.application.port.out.PendingOrderRepository;
import com.example.openapiorder.order.domain.PendingOrder;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest {
    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
    private CreateOrderService createOrderService = new CreateOrderServiceImpl(pendingOrderRepository);

    @Test
    void createPendingOrder() {
        long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = new PendingOrderRequest()
                .productId(productId)
                .quantity(quantity);
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }
}
