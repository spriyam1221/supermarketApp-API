package com.supermarketapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.supermarketapp.exception.ServiceException;
import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.Order;
import com.supermarketapp.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository  orderRepository;

	
	public void save(Order order) throws ValidationException, ServiceException  {
		try {

			orderRepository.save(order);
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	
	public List<Order> findAll() throws Exception {
		List<Order> listorder = null;
		try {
			listorder = orderRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listorder;
	}

	public Order findById(Integer userId) {

		Optional<Order> order = orderRepository.findById(userId);
		if (order.isPresent()) {
			Order orderObj = order.get();
			return orderObj;
		} else {
			return null;
		}
	}

	
}
