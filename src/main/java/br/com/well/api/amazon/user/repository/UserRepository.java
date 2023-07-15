package br.com.well.api.amazon.user.repository;

import br.com.well.api.amazon.user.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
