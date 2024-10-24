package net.javaguides.java_ems.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.java_ems.Util.JwtUtil;
import net.javaguides.java_ems.entity.Employee;
import net.javaguides.java_ems.repository.EmployeeRepository;
import net.javaguides.java_ems.dto.AuthRequest;
import net.javaguides.java_ems.dto.AuthResponse;
import net.javaguides.java_ems.dto.RegisterRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employeeRepository.save(employee);
    }

    public AuthResponse login(AuthRequest request) {
        Employee employee = employeeRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(employee.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(employee.getEmail());

        employee.setRefreshToken(refreshToken);
        employeeRepository.save(employee);

        return new AuthResponse(token, refreshToken);
    }

    public AuthResponse refresh(String refreshToken){
        String email = jwtUtil.extractUsername(refreshToken);
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        String newAccessToken = jwtUtil.generateToken(email);

        return new AuthResponse(newAccessToken, refreshToken);
    }

}
