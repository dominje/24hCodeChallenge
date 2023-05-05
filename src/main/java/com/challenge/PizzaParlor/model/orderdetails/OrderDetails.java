package com.challenge.PizzaParlor.model.orderdetails;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    @CsvBindByName
    private Integer id;

    @Column(name = "order_id")
    @CsvBindByName
    private Integer orderId;

    @Column(name = "pizza_id")
    @CsvBindByName
    private String pizzaId;

    @Column(name = "quantity")
    @CsvBindByName
    private Integer quantity;

    public OrderDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(String pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
