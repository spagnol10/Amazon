package br.com.well.api.amazon.repository;

import br.com.well.api.amazon.model.entities.user.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
