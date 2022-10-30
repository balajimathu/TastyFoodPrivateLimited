package com.tastyfoods.order.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "foodOrder_item")
@NoArgsConstructor
public class FoodOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "food_order_id")
    private FoodOrder foodOrder;
    @ManyToOne
    @JoinColumn(name="menu_item_id")
    private MenuItem menuItem;
    @Column
    private LocalDateTime created_date;
    @Column
    private LocalDateTime updated_date;
}
