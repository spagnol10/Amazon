package br.com.well.api.amazon.service;

import br.com.well.api.amazon.model.Order;
import br.com.well.api.amazon.model.User;
import br.com.well.api.amazon.model.enums.Response;
import br.com.well.api.amazon.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final Response userMessageService;

    public ResponseEntity<?> registerAndUpdate(Order order, String action) {

        if (action.equals("register")) {
            return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
        }
    }


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public ResponseEntity<?> delete(Long id) {
        orderRepository.deleteById(id);
        userMessageService.setMessage("Order deleted");
        return new ResponseEntity<>(userMessageService, HttpStatus.OK);
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
