package com.tastyfoods.search.model;

import com.tastyfoods.search.model.MenuItem.MenuItems;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Restaurant {

    @Id
    private String id;
    private String city;
    private String address;
    private String[] cuisines;
    private List<MenuItems> menuItems;
    private String lan

}
