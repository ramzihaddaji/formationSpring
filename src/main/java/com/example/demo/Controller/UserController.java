package com.example.demo.Controller;

import com.example.demo.Dto.*;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("formation/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<ResponseUser>> getAllUser() {
        List<ResponseUser> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    @PostMapping("")
    public ResponseEntity<Object> addUSer(@RequestBody @Valid RequestUser request){
        userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !!")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateUser(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestUserUpdate request) {
        userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Collections.singletonMap("message", "update succes !!!"));
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        Boolean deletedUser = userService.deleteUser(id);
        if (deletedUser) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete succes !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("messge", "department not exist"));
    }
}
