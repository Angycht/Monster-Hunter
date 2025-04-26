package com.monster.Monster.Hunter.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.Monster.Hunter.persistence.entities.RegistroRequest;
import com.monster.Monster.Hunter.persistence.entities.Role;
import com.monster.Monster.Hunter.persistence.entities.User;
import com.monster.Monster.Hunter.persistence.repository.RoleRepository;
import com.monster.Monster.Hunter.persistence.repository.UserRepository;
import com.monster.Monster.Hunter.service.util.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private  JwtTokenUtil jwtTokenUtil;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    AuthController(UserRepository userRepository,RoleRepository roleRepository,AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegistroRequest loginRequest) {
      

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        String token = jwtTokenUtil.generateToken(loginRequest.getUsername());

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role defaultRole = roleRepository.findById(3).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        user.setRole(defaultRole);
         userRepository.save(user); 
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}
