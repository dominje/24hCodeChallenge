package com.challenge.PizzaParlor.service;

import com.challenge.PizzaParlor.model.StatusDTO;
import com.challenge.PizzaParlor.model.orderdetails.OrderDetails;
import com.challenge.PizzaParlor.repository.OrderRepository;
import org.springframework.stereotype.Service;
import com.challenge.PizzaParlor.repository.OrderDetailsRepository;

import java.util.List;
import java.util.Objects;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderRepository orderRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository, OrderRepository orderRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderRepository = orderRepository;
    }
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderById(Integer id){
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public List<OrderDetails> getAllOrderDetailsByPizzaId(Integer id){
        return orderDetailsRepository.findByPizzaId(id);
    }

    public List<OrderDetails> getAllOrderDetailsByOrderId(Integer id){
        return orderDetailsRepository.findByOrderId(id);
    }

    public StatusDTO addOrderDetails(OrderDetails orderDetails) {
        if(Objects.nonNull(getOrderById(orderDetails.getId()))) {
            orderDetails.setId(orderDetailsRepository.findAll().stream().mapToInt(x -> x.getId()).max().getAsInt() + 1);
        }
        if(Objects.nonNull(orderDetails.getOrderId())){
            orderDetailsRepository.save(orderDetails);
            return new StatusDTO("success", "record successfuly saved");
        } else {
            return new StatusDTO("failed", "order id not existing");
        }
    }
}
