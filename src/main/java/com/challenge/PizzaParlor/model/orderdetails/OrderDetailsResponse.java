package com.challenge.PizzaParlor.model.orderdetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailsResponse {

    private Integer id;
    private Integer orderId;
    private String pizzaId;
    private Integer quantity;

}
