package com.supermarketapp.validator;

import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.Product;

public class ProductValidation {

	public static void productValidation(final Product product) throws ValidationException {
		
		if (product.getImageUrl() == null || product.getImageUrl().trim().equals("")) {
			throw new ValidationException("imgUrl is invalid");
		}
		if (product.getProductName() == null || product.getProductName().trim().equals("")) {
			throw new ValidationException("productname is invalid");
		}

		if (product.getMeasurement() == null || product.getMeasurement().trim().equals("")) {
			throw new ValidationException("MEASUREMENT IS INVALID");
		}
//		if (!(product.getMeasurement().equals("kg")|| product.getMeasurement().equals("lt"))){
//			throw new Exception("Enter a valid measurement(kg/lt)");
//		}

		if (product.getPrice() <= 0) {
			throw new ValidationException("price is invalid");
		}

		System.out.println("validation successfull");
	}

}
