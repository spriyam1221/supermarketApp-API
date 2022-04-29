package com.supermarketapp.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarketapp.model.Product;
import com.supermarketapp.repository.ProductRepository;

@RestController
public class ProductDetailsController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("products/save")
	public void save(@RequestBody Product product) {
		productRepository.save(product);
		System.out.println("Add product");
      
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
