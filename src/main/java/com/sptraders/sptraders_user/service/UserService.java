package com.sptraders.sptraders_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sptraders.sptraders_user.entity.User;
import com.sptraders.sptraders_user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public boolean authenticate(String username, String password) throws Exception {
		User user = userRepository.findByUsernameAndPassword(username, password);

		if (user != null) {
			return true;
		} else {
			return false;
		}

	}

}
