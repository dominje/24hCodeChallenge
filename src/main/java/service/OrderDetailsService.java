package service;

import model.Order;
import model.OrderDetails;
import org.springframework.stereotype.Service;
import repository.OrderDetailsRepository;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderById(Integer id){
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public List<OrderDetails> getAllOrderDetailsByPizzaId(Integer id){
        return orderDetailsRepository.findByPizzaId(id);
    }

    public List<OrderDetails> getAllOrderDetailsByOrderId(Integer id){
        return orderDetailsRepository.findByOrderId(id);
    }
}
