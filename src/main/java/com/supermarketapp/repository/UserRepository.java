package com.supermarketapp.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarketapp.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);

//	int validateForgetPassword(String password, String email);

	

	

	



}
