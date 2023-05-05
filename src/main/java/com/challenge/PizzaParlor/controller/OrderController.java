package com.challenge.PizzaParlor.controller;

import com.challenge.PizzaParlor.mapper.OrderMapper;
import com.challenge.PizzaParlor.model.order.Order;
import com.challenge.PizzaParlor.model.order.OrderRequest;
import com.challenge.PizzaParlor.model.order.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.challenge.PizzaParlor.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private OrderMapper orderMapper;

    @PostMapping("/getAll")
    public List<OrderResponse> getAllOrders(){
        List<Order> orderList = orderService.getAllOrders();
        return orderList.stream().map(order -> orderMapper.toResponse(order)).collect(Collectors.toList());
    }

}
