package com.challenge.PizzaParlor.service;

import com.challenge.PizzaParlor.model.order.Order;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.challenge.PizzaParlor.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order submitNewOrder(Order order) {
        return orderRepository.save(order);
    }
}
