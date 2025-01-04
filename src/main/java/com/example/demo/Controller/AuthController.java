package com.example.demo.Controller;

import com.example.demo.Dto.login.LoginRequest;
import com.example.demo.Dto.login.RequestRegister;
import com.example.demo.Dto.login.ResponseUser;
import com.example.demo.ServiceImpl.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseUser> register(@RequestBody @Valid RequestRegister request) {
        ResponseUser response = userService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseUser> login(@RequestBody @Valid LoginRequest request) {
        ResponseUser response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
