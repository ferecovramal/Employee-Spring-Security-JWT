package net.javaguides.java_ems.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.java_ems.dto.AuthRequest;
import net.javaguides.java_ems.dto.AuthResponse;
import net.javaguides.java_ems.dto.RegisterRequest;
import net.javaguides.java_ems.service.impl.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody String refreshToken){
        AuthResponse response = authService.refresh(refreshToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
