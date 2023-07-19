package br.com.well.api.amazon.repository;

import br.com.well.api.amazon.model.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
