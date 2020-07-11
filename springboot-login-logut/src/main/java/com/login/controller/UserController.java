package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.bean.User;
import com.login.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Register user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws Exception 
	 */
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {

		return userService.registerUser(user);

	}

	/**
	 * Find all users.
	 *
	 * @return the list
	 */
	@GetMapping("/all")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PutMapping("/login/username/{username}/password/{password}")
	public User verifyUser(@PathVariable String username, @PathVariable String password) throws Exception {

		return userService.verifyUser(username, password);

	}

	@DeleteMapping("/delete/{emailId}")
	public void deleteUser(@PathVariable String emailId) {
		userService.deleteUser(emailId);
	}

	@GetMapping("/validateOTP/{username}/{password}/{otp}")
	public boolean validateOTP(@PathVariable String username, @PathVariable String password, @PathVariable String otp) throws Exception {
		return userService.validateUser(username, password, otp);

	}
}
