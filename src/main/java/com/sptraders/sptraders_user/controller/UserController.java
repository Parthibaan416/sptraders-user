package com.sptraders.sptraders_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sptraders.sptraders_user.dto.UserDTO;
import com.sptraders.sptraders_user.service.UserService;
import com.sptraders.sptraders_user.util.JwtUtil;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody UserDTO userDTO) throws Exception
	{
		boolean isAuthenticated = userService.authenticate(userDTO.getUsername(), userDTO.getPassword());
		
		if(isAuthenticated) {
			String token = jwtUtil.generateToken(userDTO.getUsername());
			return ResponseEntity.ok(token);
		}
		else
		{
			return ResponseEntity.status(401).body("Invalid Credentials");
		}
	}

}
