package br.com.well.api.amazon.repository;

import br.com.well.api.amazon.model.Order;
import br.com.well.api.amazon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
