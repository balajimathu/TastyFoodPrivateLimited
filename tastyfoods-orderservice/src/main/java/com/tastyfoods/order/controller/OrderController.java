package com.tastyfoods.order.controller;


import com.tastyfoods.order.model.Order;
import com.tastyfoods.order.model.OrderRequest;
import com.tastyfoods.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orOrderService ;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest orderRequest){

        return Order.builder().build();
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody OrderRequest orderRequest){

        return Order.builder().build();
    }

    @DeleteMapping("/cancel")
    public Order cancelOrder(@RequestBody OrderRequest orderRequest){

        return Order.builder().build();
    }

    @GetMapping("/view")
    public Order getOrder(@PathVariable long id){

        return Order.builder().build();
    }

    @PostMapping("/getPrice")
    public Order getOrder(@RequestBody OrderRequest orderRequest){

        return Order.builder().build();
    }

}