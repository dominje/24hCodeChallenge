package com.challenge.PizzaParlor.controller;

import com.challenge.PizzaParlor.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.challenge.PizzaParlor.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void submitNewOrder(@RequestBody Order order){
        orderService.submitNewOrder(order);
    }

}
