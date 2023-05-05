package com.challenge.PizzaParlor.model.pizza;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Pizza {

    @Id
    @Column(name = "pizza_id")
    @CsvBindByName
    private String id;

    @Column(name = "pizza_type_id")
    @CsvBindByName
    private String pizzaTypeId;

    @Column(name = "size")
    @CsvBindByName
    private String size;

    @Column(name = "price")
    @CsvBindByName
    private float price;

    public Pizza() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPizzaTypeId() {
        return pizzaTypeId;
    }

    public void setPizzaTypeId(String pizzaTypeId) {
        this.pizzaTypeId = pizzaTypeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
