package com.tastyfoods.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String pincode;
    @Column
    private String address;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_menuitem",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id"))
    private Set<MenuItem> menuItems;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_cuisine",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id"))
    private Set<Cuisine> cuisines;
    @Column
    private LocalDateTime created_date;
    @Column
    private LocalDateTime updated_date;
    @Column
    private String phone_number;
    @Column
    private String open_hours;
    @Column
    private Double budget;


}
