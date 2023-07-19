package br.com.well.api.amazon.controller;

import br.com.well.api.amazon.model.entities.user.Order;
import br.com.well.api.amazon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Order order) {
        return service.register(order);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Order order) {
        return service.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
