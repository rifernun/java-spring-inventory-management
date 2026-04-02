package com.richard.inventorymanagement.auth.controller;


import com.richard.inventorymanagement.shared.dto.ResponseDto;
import com.richard.inventorymanagement.auth.service.JweService;
import com.richard.inventorymanagement.shared.domain.UserRole;
import com.richard.inventorymanagement.user.dto.UserResponseDto;
import com.richard.inventorymanagement.user.entity.User;
import com.richard.inventorymanagement.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JweService jweService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JweService jweService, UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jweService = jweService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public record AuthRegisterRequest(String email, String name, String password) {}
    public record AuthLoginRequest(String email, String password) {}

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody AuthLoginRequest request) throws Exception {
        //vai chamar o CustomUserDetails para verificar se o usuario existe e se a senha esta correta
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.email());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        String token = jweService.generateToken(userDetails);
        Optional<User> userSigned = userRepository.findByEmail(request.email());
        UserResponseDto response = new UserResponseDto(userSigned.get().getId(), userSigned.get().getName(), token);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody AuthRegisterRequest request) {
        if(userRepository.findByName(request.name()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(HttpStatus.CONFLICT,"User with this e-mail already exists"));
        }

        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password));
        newUser.setRole(UserRole.USER);

        User user = userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, "User created with id: " + user.getId()));
    }
}
