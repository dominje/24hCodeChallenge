package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "order_id")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "pizza_id")
    private String pizzaId;

    @Column(name = "quantity")
    private Integer quantity;


}
