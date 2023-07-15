package br.com.well.api.amazon.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.well.api.amazon.user.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
