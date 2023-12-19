package br.com.well.api.amazon.core.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.well.api.amazon.core.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
