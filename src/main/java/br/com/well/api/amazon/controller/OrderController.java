package br.com.well.api.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.well.api.amazon.model.Order;
import br.com.well.api.amazon.service.OrderService;

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
