package com.example.openapiorder.order.application;

import com.example.openapiorder.order.application.port.in.GetPendingOrderService;
import com.example.openapiorder.order.application.port.out.LoadPendingOrderPort;
import com.example.openapiorder.order.domain.PendingOrder;
import org.springframework.stereotype.Service;

@Service
class GetPendingOrderServiceImpl implements GetPendingOrderService {
    private final LoadPendingOrderPort loadPendingOrderPort;

    GetPendingOrderServiceImpl(LoadPendingOrderPort loadPendingOrderPort) {
        this.loadPendingOrderPort = loadPendingOrderPort;
    }

    @Override
    public PendingOrder getPendingOrder(Long id) {
        return loadPendingOrderPort.loadPendingOrder(id);
    }
}
