/*
 * AuthController - REST controller for user authentication and registration.
 */

package io.github.andrewherubin.taskflow.controller;

import io.github.andrewherubin.taskflow.dto.AuthRequest;
import io.github.andrewherubin.taskflow.dto.AuthResponse;
import io.github.andrewherubin.taskflow.model.User;
import io.github.andrewherubin.taskflow.service.JwtService;
import io.github.andrewherubin.taskflow.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, JwtService jwtService,
                          PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Operation(summary = "Register a new user")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User registered successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody AuthRequest request) {
        User user = new User(request.getUsername(), passwordEncoder.encode(request.getPassword()));
        userService.save(user);

        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    @Operation(summary = "Authenticate a user and return a JWT")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "User authenticated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "401", description = "Invalid username or password")
    })
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return new AuthResponse(jwtService.generateToken(request.getUsername()));
    }
}
