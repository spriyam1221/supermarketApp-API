package com.supermarketapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.supermarketapp.exception.ServiceException;
import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.UserRepository;
import com.supermarketapp.validator.UserValidator;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void save(User user) throws ValidationException, ServiceException {
		System.out.println("Userservice->save:" + user);
		try {
			UserValidator.validateUserDetails(user);
			userRepository.save(user);
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public String login(User user) throws ValidationException, ServiceException {
		System.out.println("Userservice->login:" + user);
		try {
			UserValidator.validateLogin(user);
			Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (userObj.isPresent()) {
				// User userObj = user.get();
				return "success";
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
	}

	public List<User> findAll() throws Exception {
		List<User> UserList = null;
		try {
			UserList = userRepository.findAll();

		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return UserList;
	}

	public void deleteById(Integer userId) throws Exception {
		try {
			userRepository.deleteById(userId);
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(Integer userId, User user) throws Exception {
		try {
			user.setUserId(userId);
			userRepository.save(user);
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public User findById(Integer userId) {

		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User userObj = user.get();
			return userObj;
		} else {
			return null;
		}
	}

//	public Object forgotPassword(String password, String email) {
//		System.out.println("Userservice->forgotPassword:" + email, password); 
////		UserValidator.validateForgetPassword(user);
////		userRepository.forGotPassword(user);
//		UserValidator.validateForgetPassword(email, password);
//		return null;
//	}

}
