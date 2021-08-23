package com.example.openapiorder.order.application.port.in;

import com.example.openapiorder.order.domain.PendingOrder;

public interface GetPendingOrderService {
    PendingOrder getPendingOrder(Long id);
}