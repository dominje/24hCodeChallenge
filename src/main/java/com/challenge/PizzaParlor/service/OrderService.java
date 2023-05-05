package com.challenge.PizzaParlor.service;

import com.challenge.PizzaParlor.model.order.Order;
import org.springframework.stereotype.Service;
import com.challenge.PizzaParlor.repository.OrderRepository;
import java.util.List;
import java.util.Objects;

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
        if(Objects.nonNull(getOrderById(order.getId()))) {
            order.setId(orderRepository.findAll().stream().mapToInt(x -> x.getId()).max().getAsInt() + 1);
        }
        return orderRepository.save(order);
    }
}
