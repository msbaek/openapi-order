package com.example.openapiorder.order.application.port.out;

import com.example.openapiorder.order.domain.PendingOrder;

public interface LoadPendingOrderPort {
    PendingOrder loadPendingOrder(Long id);
}
