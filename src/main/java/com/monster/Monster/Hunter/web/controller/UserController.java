package com.monster.Monster.Hunter.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.Monster.Hunter.persistence.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	    private UserRepository userRepository;

	    @GetMapping("/profile")
	    public ResponseEntity<?> getProfile(Authentication authentication) {
	    	if (authentication == null || !authentication.isAuthenticated()) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
	        }
	        String username = authentication.getName();
	        return userRepository.findByUsername(username)
	            .map(user -> {
	                Map<String, String> response = new HashMap<>();
	                response.put("username", user.getUsername());
	                return ResponseEntity.ok(response);
	            })
	            .orElse(ResponseEntity.notFound().build());
	    }

}
