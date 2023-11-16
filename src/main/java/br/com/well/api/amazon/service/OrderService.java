package br.com.well.api.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.well.api.amazon.core.model.entities.Order;
import br.com.well.api.amazon.core.model.enums.ResponseUser;
import br.com.well.api.amazon.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ResponseUser messageOrder;

    public ResponseEntity<?> register(Order order) {
        if (order.getMoment().equals(null)) {
            messageOrder.setMessage("Moment is requerid");
            return new ResponseEntity<>(messageOrder, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
        }
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }

    public ResponseEntity<?> update(Order order) {
        if (order.getMoment().equals(null)) {
            messageOrder.setMessage("Moment is requerid");
            return new ResponseEntity<>(messageOrder, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        orderRepository.deleteById(id);
        messageOrder.setMessage("Order deleted");
        return new ResponseEntity<>(messageOrder, HttpStatus.OK);
    }
}
