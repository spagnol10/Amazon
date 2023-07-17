package br.com.well.api.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.well.api.amazon.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
