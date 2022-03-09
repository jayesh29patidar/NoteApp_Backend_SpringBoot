package com.notesapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesapp.model.User;
import com.notesapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> loginUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
	}

}
