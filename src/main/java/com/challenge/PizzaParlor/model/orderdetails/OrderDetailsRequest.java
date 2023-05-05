package com.challenge.PizzaParlor.model.orderdetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsRequest {

    private Integer orderId;
    private String pizzaId;
    private Integer quantity;

}
