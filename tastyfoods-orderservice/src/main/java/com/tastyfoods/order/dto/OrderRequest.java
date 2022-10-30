package com.tastyfoods.order.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@Builder
public class OrderRequest {

    @NotNull
    private long customerId;
    @NotNull
    private long restaurantId;
    @NotNull
    @NotEmpty
    private Set<FoodOrderItem> foodOrderItems;
}