package com.example.EventManagement.Controller;

import com.example.EventManagement.DTO.LoginRequest;
import com.example.EventManagement.Model.User;
import com.example.EventManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByName(loginRequest.getName());

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.status(401).body("Name or password is wrong");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.existsByName(user.getName())) {
            return ResponseEntity.status(409).body("Username already exists, please try another name");
        } else {
            String response = userService.save(user);
            return ResponseEntity.ok(response);
        }
    }
}
