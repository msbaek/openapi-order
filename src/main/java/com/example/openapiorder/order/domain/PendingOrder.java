package com.example.openapiorder.order.domain;

import lombok.Getter;

@Getter
public class PendingOrder {
    private long id;
    private long productId;
    private int quantity;

    public PendingOrder(long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrder create(Long productId, Integer quantity) {
        return new PendingOrder(0L, productId, quantity);
    }

    public void assignId(long nextId) {
        this.id = nextId;
    }
}
