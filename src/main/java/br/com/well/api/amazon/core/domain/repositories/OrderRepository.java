package br.com.well.api.amazon.core.domain.repositories;

import br.com.well.api.amazon.core.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
