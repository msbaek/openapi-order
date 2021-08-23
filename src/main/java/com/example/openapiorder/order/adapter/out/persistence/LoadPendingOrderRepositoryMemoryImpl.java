package com.example.openapiorder.order.adapter.out.persistence;

import com.example.openapiorder.order.application.port.out.LoadPendingOrderPort;
import com.example.openapiorder.order.application.port.out.PendingOrderRepository;
import com.example.openapiorder.order.domain.PendingOrder;
import org.springframework.stereotype.Repository;

@Repository
public class LoadPendingOrderRepositoryMemoryImpl implements LoadPendingOrderPort {
    private final PendingOrderRepository pendingOrderRepository;

    public LoadPendingOrderRepositoryMemoryImpl(PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder loadPendingOrder(Long id) {
        return pendingOrderRepository.findById(id);
    }
}
