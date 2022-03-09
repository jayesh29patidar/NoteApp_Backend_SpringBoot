package com.notesapp.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.notesapp.model.User;

public interface UserService {

	public List<User> getUsers();

	public User createUser(@RequestBody User user);

	public List<User> loginUser(@RequestBody User user);

}
