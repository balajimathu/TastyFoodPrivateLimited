package com.tastyfoods.order.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "menu_item")
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;
    @Column
    private Double price;
    @Column
    private Boolean veg;
    @Column
    private LocalDateTime created_date;
    @Column
    private LocalDateTime updated_date;
}
