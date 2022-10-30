package com.tastyfoods.order.dao;


import com.tastyfoods.order.model.FoodOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderItemRepository extends JpaRepository<FoodOrderItem, Long> {

}
