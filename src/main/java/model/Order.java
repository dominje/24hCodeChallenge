package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

}
