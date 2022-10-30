package com.tastyfoods.order.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUISINE")
@NoArgsConstructor
@Getter
@Setter
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private LocalDateTime created_date;
    @Column
    private LocalDateTime updated_date;
}
