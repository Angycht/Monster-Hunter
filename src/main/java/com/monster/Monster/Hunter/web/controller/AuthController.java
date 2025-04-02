package com.monster.Monster.Hunter.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.Monster.Hunter.service.dto.LoginDto;
import com.monster.Monster.Hunter.web.config.JwtUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager autenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<Void> login (LoginDto loginDto){
		
		UsernamePasswordAuthenticationToken login=new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
		org.springframework.security.core.Authentication authentication=this.autenticationManager.authenticate(login);
		
		if(authentication.isAuthenticated()) {
			String jwt=this.jwtUtils.create(loginDto.getUsername());
			return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.AUTHORIZATION, jwt).build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
