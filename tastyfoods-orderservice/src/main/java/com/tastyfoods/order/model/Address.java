package com.tastyfoods.order.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String addressLineOne;
    @Column
    private String addressLineTwo;
    @Column
    private String city;
    @Column
    private Integer postalCode;
    @Column
    private String landmark;
    @Column
    private LocalDateTime created_date;
    @Column
    private LocalDateTime updated_date;
}
