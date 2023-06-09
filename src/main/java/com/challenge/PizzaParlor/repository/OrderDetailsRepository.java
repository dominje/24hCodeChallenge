package com.challenge.PizzaParlor.repository;

import com.challenge.PizzaParlor.model.orderdetails.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    List<OrderDetails> findByPizzaId(Integer id);
    List<OrderDetails> findByOrderId(Integer id);

}
