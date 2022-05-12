package com.supermarketapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.supermarketapp.exception.ServiceException;
import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.Product;
import com.supermarketapp.repository.ProductRepository;
import com.supermarketapp.validator.ProductValidation;

@Service
public class ProductService {
	
@Autowired
ProductRepository  productRepository;

	public  void save(Product product) throws ValidationException, ServiceException
	{
		System.out.println("ProductService->save:"+product);
		try {
			ProductValidation.productValidation(product);
			
		 productRepository.save(product);
		} catch (DataAccessException e) {
			

			throw new ServiceException("product name is not unique"+e.getMessage());

		}
	}
	
	public List<Product> findAll() throws Exception {
		List<Product> listProduct = null;
		try {
			listProduct = productRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listProduct;
	}
	
	public void deleteById(Integer productId) throws Exception {
		try {
			productRepository.deleteById(productId);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void update(Integer productId, Product product) throws Exception {
		try {
			product.setProductId(productId);
			productRepository.save(product);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public Product findById(Integer productId) {

		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			Product productObj = product.get();
			return productObj;
		} else {
			return null;
		}
	}
}
