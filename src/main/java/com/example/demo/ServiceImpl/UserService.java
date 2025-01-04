package com.example.demo.ServiceImpl;

import com.example.demo.Dto.login.LoginRequest;
import com.example.demo.Dto.login.RequestRegister;
import com.example.demo.Dto.login.ResponseUser;
import com.example.demo.Entities.UserL;
import com.example.demo.Repository.UserLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserLRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseUser register(RequestRegister request) {
        Optional<UserL> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        UserL user = new UserL();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user = userRepository.save(user);

        return new ResponseUser(user.getId(), user.getName(), user.getEmail());
    }

    public ResponseUser login(LoginRequest request) {
        UserL user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new ResponseUser(user.getId(), user.getName(), user.getEmail());
    }
}
