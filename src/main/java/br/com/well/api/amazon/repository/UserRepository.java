package br.com.well.api.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.well.api.amazon.model.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
