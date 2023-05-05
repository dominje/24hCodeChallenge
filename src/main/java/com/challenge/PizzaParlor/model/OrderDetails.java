package com.challenge.PizzaParlor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    private String pizzaId;

    @Column(name = "quantity")
    private Integer quantity;


}
