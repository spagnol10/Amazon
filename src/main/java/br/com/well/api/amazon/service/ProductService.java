package br.com.well.api.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.well.api.amazon.core.domain.entities.Product;
import br.com.well.api.amazon.core.domain.enums.Responseproduct;
import br.com.well.api.amazon.core.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final Responseproduct message;

    public ResponseEntity<?> register(Product product) {
        if (product.getName().isEmpty()) {
            message.setMessage("Product name is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
        }
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> user = repository.findById(id);
        return user.get();
    }

    public ResponseEntity<?> update(Product product) {
        if (product.getName().isEmpty()) {
            message.setMessage("User name is required");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.save(product), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> delete(Long id) {
        repository.deleteById(id);
        message.setMessage("User deleted");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
