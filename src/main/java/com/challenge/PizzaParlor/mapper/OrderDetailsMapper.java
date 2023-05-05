package com.challenge.PizzaParlor.mapper;


import com.challenge.PizzaParlor.model.order.Order;
import com.challenge.PizzaParlor.model.order.OrderRequest;
import com.challenge.PizzaParlor.model.order.OrderResponse;
import com.challenge.PizzaParlor.model.orderdetails.OrderDetails;
import com.challenge.PizzaParlor.model.orderdetails.OrderDetailsRequest;
import com.challenge.PizzaParlor.model.orderdetails.OrderDetailsResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {

    public OrderDetailsResponse toResponse(OrderDetails orderDetails) {
        OrderDetailsResponse response = new OrderDetailsResponse();
        BeanUtils.copyProperties(orderDetails, response);
        return response;
    }

    public OrderDetails toEntity(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(orderDetailsRequest.getOrderId());
        orderDetails.setPizzaId(orderDetailsRequest.getPizzaId());
        orderDetailsRequest.setQuantity(orderDetailsRequest.getQuantity());
        return orderDetails;
    }
}
