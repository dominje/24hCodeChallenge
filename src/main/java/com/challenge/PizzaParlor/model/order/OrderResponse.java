package com.challenge.PizzaParlor.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {

    private Integer id;
    private String date;
    private String time;

}
