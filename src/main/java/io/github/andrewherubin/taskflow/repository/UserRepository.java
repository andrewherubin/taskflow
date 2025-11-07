/*
 * UserRepository - repository interface for accessing user data.
 * 
 * Extends JpaRepository to provide CRUD operations for User entities and connectivity to database.
 */

package io.github.andrewherubin.taskflow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.andrewherubin.taskflow.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
}
