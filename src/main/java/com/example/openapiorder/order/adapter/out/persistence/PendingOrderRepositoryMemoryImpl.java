package com.example.openapiorder.order.adapter.out.persistence;

import com.example.openapiorder.order.application.port.out.PendingOrderRepository;
import com.example.openapiorder.order.domain.PendingOrder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {
    private final AtomicLong pendingOrderId = new AtomicLong(1);
    private Map<Long, PendingOrder> map = new HashMap<>();

    @Override
    public PendingOrder save(PendingOrder pendingOrder) {
        pendingOrder.assignId(nextId());
        map.put(pendingOrder.getId(), pendingOrder);
        return pendingOrder;
    }

    @Override
    public PendingOrder findById(Long id) {
        return map.get(id);
    }

    private long nextId() {
        return pendingOrderId.getAndIncrement();
    }
}
