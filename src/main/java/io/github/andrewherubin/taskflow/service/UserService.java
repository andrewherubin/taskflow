/*
 * UserService - service class for managing user details and authentication.
 */

package io.github.andrewherubin.taskflow.service;

import io.github.andrewherubin.taskflow.model.User;
import io.github.andrewherubin.taskflow.repository.UserRepository;

import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    // Repository for user data
    private final UserRepository userRepository;

    // Constructor to initialize UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Load user by username from the repository/database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    // Save a new user to the repository/database
    public User save(@NonNull User user) {
        return userRepository.save(user);
    }
}
