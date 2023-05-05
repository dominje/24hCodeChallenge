package com.challenge.PizzaParlor.controller;

import com.challenge.PizzaParlor.mapper.OrderMapper;
import com.challenge.PizzaParlor.model.order.Order;
import com.challenge.PizzaParlor.model.order.OrderRequest;
import com.challenge.PizzaParlor.model.order.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.challenge.PizzaParlor.service.OrderService;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private OrderMapper orderMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse submitNewOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println(orderRequest.getDate());
        System.out.println(orderRequest.getTime());
        orderMapper = new OrderMapper();
        Order order = orderMapper.toEntity(orderRequest);
        return orderMapper.toResponse(orderService.submitNewOrder(order));

    }

}
