package br.com.well.api.amazon.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.well.api.amazon.product.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
