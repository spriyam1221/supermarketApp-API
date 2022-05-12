package com.supermarketapp.controller;


import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.dto.MessageDTO;
import com.supermarketapp.exception.ServiceException;
import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.UserRepository;
import com.supermarketapp.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserDetailsController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@PostMapping("Users/save")
	public ResponseEntity<?> save(@RequestBody User user) {
		try {
			userService.save(user);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("Users/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			String ln=userService.login(user);
			MessageDTO message = new MessageDTO("success");
			if(ln=="success") {
			return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	
	
	
	@GetMapping("Users/list")
	public List<User> findAll() {
		List<User> UserList = userRepository.findAll();
		return UserList;
	}

	@DeleteMapping("Users/{userId}")
	public void delete(@PathVariable("userId") Integer userId) {
		log.debug("deletedbyid -{}", userId);
		userRepository.deleteById(userId);
	}

	@PutMapping("Users/{userId}")
	public void update(@PathVariable("userId") Integer userId, @RequestBody User user) {
		user.setUserId(userId);
		userRepository.save(user);
	}

	@GetMapping("Users/{userId}")
	public User findById(@PathVariable("userId") Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
//	@PostMapping("Users/forgotPassword")
//	public Object forgotPassword(@RequestBody User user) throws SQLException{
//		String password = user.getPassword();
//		String email = user.getEmail();
//		return userService.forgotPassword(password,email);
//	}
}
