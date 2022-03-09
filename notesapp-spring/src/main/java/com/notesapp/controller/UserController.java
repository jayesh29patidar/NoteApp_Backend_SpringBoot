package com.notesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesapp.model.User;
import com.notesapp.services.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.getUsers();
	}

//	 create add student
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		System.out.println(user.toString());
		return userService.createUser(user);
	}

// login user
	@PostMapping("/user/login")
	public List<User> loginUser(@RequestBody User user) {
		System.out.println("login called");
		return userService.loginUser(user);
	}

}
