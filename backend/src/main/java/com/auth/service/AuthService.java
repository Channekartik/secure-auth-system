package com.auth.service;

import com.auth.dto.*;
import com.auth.entity.*;
import com.auth.exception.UserAlreadyExistsException;
import com.auth.repository.UserRepository;
import com.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Business logic for registration and login.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        /**
         * Register a new user.
         * 1. Check if email already exists
         * 2. Hash password with BCrypt
         * 3. Save user to DB
         * 4. Generate and return JWT
         */
        public AuthResponse register(RegisterRequest request) {
                if (userRepository.existsByEmail(request.getEmail())) {
                        throw new UserAlreadyExistsException(
                                        "Email already registered: " + request.getEmail());
                }

                User user = User.builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword())) // BCrypt
                                .role(Role.USER)
                                .enabled(true)
                                .build();

                userRepository.save(user);

                String token = jwtService.generateToken(user);

                return AuthResponse.builder()
                                .token(token)
                                .name(user.getName())
                                .email(user.getEmail())
                                .role(user.getRole().name())
                                .message("Registration successful")
                                .build();
        }

        /**
         * Login an existing user.
         * 1. Authenticate via Spring Security (throws BadCredentialsException on
         * failure)
         * 2. Generate and return JWT
         */
        public AuthResponse login(LoginRequest request) {
                // This call throws BadCredentialsException if credentials are wrong
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                User user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new RuntimeException("User not found"));

                String token = jwtService.generateToken(user);

                return AuthResponse.builder()
                                .token(token)
                                .name(user.getName())
                                .email(user.getEmail())
                                .role(user.getRole().name())
                                .message("Login successful")
                                .build();
        }
}