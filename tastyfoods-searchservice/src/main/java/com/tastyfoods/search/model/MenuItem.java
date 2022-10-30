package com.tastyfoods.search.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
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
