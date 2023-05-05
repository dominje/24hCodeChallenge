package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PizzaType {

    @Id
    @Column(name = "pizza_type_id")
    @OneToMany(fetch = FetchType.LAZY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "ingredients")
    private String ingredients;

}
