package com.supermarketapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.exception.ServiceException;
import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.Order;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.OrderRepository;
import com.supermarketapp.service.OrderService;

@SuppressWarnings("unused")
@RestController
public class OrderDetailsController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderService orderservice;
	
	@PostMapping("orders/save")
	public ResponseEntity<?> save(@RequestBody Order order)  {
		try {
			orderservice.save(order);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
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
	
	

