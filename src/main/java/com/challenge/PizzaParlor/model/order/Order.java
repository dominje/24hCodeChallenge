package com.challenge.PizzaParlor.model.order;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "`ORDER`")
public class Order{

    @Id
    @Column(name = "order_id")
    @CsvBindByName
    private Integer order_id;

    @Column(name = "date")
    @CsvBindByName
    private String date;

    @Column(name = "time")
    @CsvBindByName
    private String time;

    public Order() {
    }

    public Integer getId() {
        return order_id;
    }

    public void setId(Integer id) {
        this.order_id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
