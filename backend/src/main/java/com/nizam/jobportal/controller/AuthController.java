package com.nizam.jobportal.controller;

import com.nizam.jobportal.entity.User;
import com.nizam.jobportal.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Simple login: provide email, return user object
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        if(email == null) return ResponseEntity.badRequest().build();

        // Try to find user by email
        User user = userService.getByEmail(email);
        if(user == null) {
            // If user doesn't exist, create new user with email
            user = new User();
            user.setEmail(email);
            user = userService.createOrUpdate(user);
        }

        Map<String, Object> resp = new HashMap<>();
        resp.put("userId", user.getId());
        resp.put("email", user.getEmail());
        resp.put("username", user.getUsername());

        return ResponseEntity.ok(resp);
    }
}
