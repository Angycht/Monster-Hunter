package com.monster.Monster.Hunter.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	private final RoleRepository roleRepository;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final PasswordEncoder passwordEncoder;

	public AuthController(UserRepository userRepository, RoleRepository roleRepository,
			AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody RegistroRequest loginRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			User user = userRepository.findByUsername(loginRequest.getUsername())
					.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

			String token = jwtTokenUtil.generateToken(user.getUsername(), user.getRole().getNombre());

			return ResponseEntity.ok(token);

		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
		}
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
