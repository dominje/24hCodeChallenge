package com.challenge.PizzaParlor.model.pizzatype;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class PizzaType {

    @Id
    @Column(name = "pizza_type_id")
    @CsvBindByName
    private String id;

    @Column(name = "name")
    @CsvBindByName
    private String name;

    @Column(name = "category")
    @CsvBindByName
    private String category;

    @Column(name = "ingredients")
    @CsvBindByName
    private String ingredients;


    public PizzaType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
