package com.example.openapiorder.order.application.port.in;

import com.example.openapiorder.order.domain.PendingOrder;
import io.tej.SwaggerCodgen.model.PendingOrderRequest;

public interface CreateOrderService {
    PendingOrder createPendingOrder(PendingOrderRequest request);
}
