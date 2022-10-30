insert
into
  CUISINE
  (id, name, created_date, updated_date)
values
  (1, 'SOUTH_INDIAN', NOW(), NOW());
insert
into
  CUISINE
  (id, name, created_date, updated_date)
values
  (2, 'NORTH_INDIAN', NOW(), NOW());
insert
  into
    CUISINE
    (id, name, created_date, updated_date)
  values
    (3, 'CHINESE', NOW(), NOW());
insert
  into
    CUISINE
    (id, name, created_date, updated_date)
  values
    (4, 'ITALIAN', NOW(), NOW());


insert into restaurant
  (id,name, city, pincode, address, latitude, longitude, created_date, updated_date, phone_number, open_hours, budget)
values
  (1,'Tasty_WhiteField', 'Bangalore', '560091', 'WhileField', 12.9958, 77.6964, NOW(), NOW(), '08012345678', '12.30PM-10.00PM', 250.00);


insert
into
  restaurant
  (id, name, city, pincode, address, latitude, longitude, created_date, updated_date, phone_number, open_hours, budget)
values
  (2,  'Tasty_Koramangala', 'Bangalore', '560083', 'Koramangala', 12.9346, 77.6133, NOW(), NOW(), '08012345677', '12.30PM-10.00PM', 200);


insert
into
  restaurant
  (id,  name, city, pincode, address, latitude, longitude, created_date, updated_date, phone_number, open_hours, budget)
values
  (3, 'Tasty_MysoreRoad', 'Bangalore', '560098', 'Mysore Road', 12.9360, 77.5178, NOW(), NOW(), '08012345675', '12.30PM-10.00PM', 250);


insert into menu_item(id,name,price,veg,created_date,updated_date)
values (1,'IDLY',50.00,FALSE,NOW(),NOW());
insert into menu_item(id,name,price,veg,created_date,updated_date)
values (2,'DOSA',60.00,FALSE,NOW(),NOW());
insert into menu_item(id,name,price,veg,created_date,updated_date)
values (3,'VADA',40.00,FALSE,NOW(),NOW());
insert into menu_item(id,name,price,veg,created_date,updated_date)
values (4, 'PONGAL', 60.00,FALSE,NOW(),NOW());
insert into menu_item(id,name,price,veg,created_date,updated_date)
values (5, 'POORI', 60.00,FALSE,NOW(),NOW());


insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (1, 1);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (2, 1);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (3, 1);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (1, 2);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (2, 2);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (3, 2);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (1, 3);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (2, 3);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (3, 3);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (1, 4);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (2, 4);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (3, 4);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (1, 5);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (2, 5);
insert into restaurant_menuitem (restaurant_id, menu_item_id)
        values (3, 5);




insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (1, 1);
insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (2, 1);
insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (3, 1);
insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (1, 2);
insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (2, 3);
insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (1, 4);
insert into restaurant_cuisine (restaurant_id, cuisine_id)
        values (1, 3);

insert into customer(id,first_name,last_name,phone_number,mail_id,created_date,updated_date)
values (1001,'Balaji','Madhaiyan','9912345678','balaji@gmail.com',NOW(),NOW());
insert into customer(id,first_name,last_name,phone_number,mail_id,created_date,updated_date)
values (1002,'Arun', 'Kumar', '8812345678', 'Arun@gmail.com', NOW(), NOW());
insert into customer(id,first_name,last_name,phone_number,mail_id,created_date,updated_date)
values (1003,'Siva','Prasad','7712345678','Siva@gmail.com',NOW(),NOW());
insert into customer(id,first_name,last_name,phone_number,mail_id,created_date,updated_date)
values (1004,'Kala','Suresh','6612345678','Kala@gmail.com',NOW(), NOW());