package com.tastyfoods.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phoneNumber;
    @Column
    private String mailId;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column
    private LocalDateTime created_date;
    @Column
    private LocalDateTime updated_date;

}