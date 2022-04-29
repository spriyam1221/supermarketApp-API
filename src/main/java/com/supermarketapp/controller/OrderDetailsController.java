package com.supermarketapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.model.Order;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.OrderRepository;
import com.supermarketapp.repository.UserRepository;

@SuppressWarnings("unused")
@RestController
public class OrderDetailsController {

	@Autowired
	OrderRepository orderRepository;

	@PostMapping("Orders/save")
	public void save(@RequestBody Order order) {
		orderRepository.save(order);
		System.out.println("success");
	}
}
