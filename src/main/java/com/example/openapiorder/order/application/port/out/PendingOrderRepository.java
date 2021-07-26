package com.example.openapiorder.order.application.port.out;

import com.example.openapiorder.order.domain.PendingOrder;

public interface PendingOrderRepository {
    PendingOrder save(PendingOrder pendingOrder);
    PendingOrder findById(Long id);
}
