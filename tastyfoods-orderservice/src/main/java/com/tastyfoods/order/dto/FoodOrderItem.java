package com.tastyfoods.order.dto;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class FoodOrderItem {

    @NotNull
    private long menuItemId;
    @NotNull
    private int quantity;

}
