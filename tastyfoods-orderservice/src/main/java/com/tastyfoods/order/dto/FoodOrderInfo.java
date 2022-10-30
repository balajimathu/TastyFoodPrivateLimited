package com.tastyfoods.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class FoodOrderInfo {

    private long id;
    private long restaurantId;
    private Set<FoodOrderItem> foodOrderItems;
    private long customerId;
}
