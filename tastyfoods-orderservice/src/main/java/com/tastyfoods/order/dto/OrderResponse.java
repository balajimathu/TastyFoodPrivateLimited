package com.tastyfoods.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class OrderResponse {

    private Double totalPrice;
    private long orderTrackingId;
    private String status;
    private FoodOrderInfo foodOrderInfo;

}