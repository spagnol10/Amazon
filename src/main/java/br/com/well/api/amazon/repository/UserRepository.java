package br.com.well.api.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.well.api.amazon.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
