package com.tastyfoods.order.dao;


import com.tastyfoods.order.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<FoodOrder, Long> {

}
