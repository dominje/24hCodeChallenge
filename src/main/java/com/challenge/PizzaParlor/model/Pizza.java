package com.challenge.PizzaParlor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Pizza {

    @Id
    @Column(name = "pizza_id")
    private String id;

    @Column(name = "pizza_type_id")
    private String pizzaTypeId;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private float price;

}
