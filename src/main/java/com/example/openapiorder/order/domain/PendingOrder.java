package com.example.openapiorder.order.domain;

import lombok.Getter;

@Getter
public class PendingOrder {
    private long id;
    private long productId;
    private int quantity;
}
