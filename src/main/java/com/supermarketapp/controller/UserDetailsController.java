package com.supermarketapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.model.Product;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.UserRepository;

@RestController
public class UserDetailsController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("Users/login")
	public User login(@RequestBody User user) {
		Optional<User> user1 = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if (user1.isPresent()) {
			return user1.get();
		} else {
			return null;
		}
	}
	
	@PostMapping("Users/save")
	public void save(@RequestBody User user) {
		//
		
		//try {
			
			//validate
			//save
		//}
		userRepository.save(user);
		
		System.out.println("success");
	}
	@GetMapping("Users/list")
	public List<User> findAll() {
		List<User> UserList = userRepository.findAll();
		return UserList;
	}
	@DeleteMapping("Users/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	@PutMapping("Users/{userId}")
	public void update(@PathVariable("userId") Integer userId, @RequestBody User user) {
		user.setUserId(userId);
		userRepository.save(user);
	}
	@GetMapping("Users/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
}

