package it.ashyzan.pizzeria.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ashyzan.pizzeria.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
