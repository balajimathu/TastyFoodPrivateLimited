package com.tastyfoods.order.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foodOrder")
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Restaurant restaurant;
    @OneToMany(mappedBy = "foodOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FoodOrderItem> foodOrderItems;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Customer customer;
    @Column
    private Double price;
    @Column
    private String status;
}
