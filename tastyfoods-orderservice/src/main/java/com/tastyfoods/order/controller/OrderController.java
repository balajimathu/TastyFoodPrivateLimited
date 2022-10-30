package com.tastyfoods.order.controller;


import com.tastyfoods.order.dto.OrderRequest;
import com.tastyfoods.order.dto.OrderResponse;
import com.tastyfoods.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public OrderResponse placeOrder(@Valid @RequestBody OrderRequest orderRequest) {

        return orderService.placeOrder(orderRequest);
    }

    @PutMapping("/update/{orderId}")
    public OrderResponse updateOrder(@Valid @PathVariable long orderId, @Valid @RequestBody OrderRequest orderRequest) {

        return orderService.updateOrder(orderId, orderRequest);
    }

    @DeleteMapping("/cancel/{orderId}")
    public OrderResponse cancelOrder(@Valid @PathVariable long orderId) {

        return orderService.cancelOrder(orderId);
    }

    @GetMapping("/view/{orderId}")
    public OrderResponse getOrder(@Valid @PathVariable long orderId) {

        return orderService.getOrder(orderId);
    }

    @PostMapping("/getPrice")
    public OrderResponse getPriceForOrder(@Valid @RequestBody OrderRequest orderRequest) {

        return orderService.getPrice(orderRequest);
    }

}