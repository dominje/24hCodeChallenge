package com.challenge.PizzaParlor.mapper;


import com.challenge.PizzaParlor.model.order.Order;
import com.challenge.PizzaParlor.model.order.OrderRequest;
import com.challenge.PizzaParlor.model.order.OrderResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(order, response);
        return response;
    }

    public Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setDate(orderRequest.getDate());
        order.setTime(orderRequest.getTime());
        return order;
    }
}
