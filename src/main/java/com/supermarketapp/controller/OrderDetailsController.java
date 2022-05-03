package com.supermarketapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.model.Order;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.OrderRepository;

@SuppressWarnings("unused")
@RestController
public class OrderDetailsController {

	@Autowired
	OrderRepository orderRepository;

	@PostMapping("orders/save")
	public void save(@RequestBody Order order) {
		orderRepository.save(order);
		System.out.println("success");
	}
	@GetMapping("orders/list")
	public List<Order> findAll() {
		List<Order> orderList = orderRepository.findAll();
		return orderList;

	}
	@GetMapping("orders/search")
	public List<Order> findById(@RequestParam("userId") Integer userId) {
		List<Order> orderList = orderRepository.findByUserId(userId);
		return orderList;
		}
    
//	@PutMapping("orders/{id}")
//	public Integer changestatus(@PathVariable("id") Integer id,@PathVariable("status") String status, @RequestBody User user) {
//		Integer orderList = orderRepository.changestatus(id,status);
//		
//		return orderList;
//	}
	@GetMapping("orders/{id}/change-status")
	public void changeStatus(@PathVariable("id") Integer id, @RequestParam("status") String status) {
	orderRepository.changestatus(id, status);
	}
}
	
	

