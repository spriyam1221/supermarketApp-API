package com.supermarketapp.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.dto.MessageDTO;
import com.supermarketapp.exception.ServiceException;
import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.Product;
import com.supermarketapp.model.User;
import com.supermarketapp.repository.ProductRepository;
import com.supermarketapp.service.ProductService;


@RestController
public class ProductDetailsController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;
	
	@PostMapping("products/save")
//	public ResponseEntity<?> save(@RequestBody Product product) {
//
//		try {
//			productService.save(product);
//			return new ResponseEntity<String>("success", HttpStatus.OK) ;
//		} catch (ValidationException e) {
//			System.out.println(e.getMessage());
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		
//		}catch(ServiceException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//      }
	public ResponseEntity<?> save(@RequestBody Product product) {
		try {
			productService.save(product);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("products/list")
	public List<Product> findAll() {
		List<Product> productList = productRepository.findAll();
		return productList;

	}

	@DeleteMapping("products/{productId}")
	public void delete(@PathVariable("productId") Integer productId) {
		productRepository.deleteById(productId);
	}

	@PutMapping("products/{productId}")
	public void update(@PathVariable("productId") Integer productId, @RequestBody Product product) {
		product.setProductId(productId);
		productRepository.save(product);
	}
	
	@PatchMapping("products/{productId}")
	public void updatePrice(@PathVariable("productId") Integer productId, @RequestBody Product product) {
		product.setProductId(productId);
		Product productObj = productRepository.findById(productId).get();
		productObj.setPrice(product.getPrice()); 
		productRepository.save(productObj);
	}

	@GetMapping("products/{productId}")
	public Product fingByProductId(@PathVariable("productId") Integer productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
}
