package model;

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
    @OneToMany(fetch = FetchType.LAZY)
    private String id;

    @Column(name = "pizza_type_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private List<PizzaType> pizzaType;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private float price;

}
