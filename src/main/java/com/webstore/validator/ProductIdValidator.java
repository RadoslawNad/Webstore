package com.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webstore.domain.Product;
import com.webstore.exception.ProductNotFoundException;
import com.webstore.service.ProductService;

@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {
	
	@Autowired
	private ProductService productService;

	public void initialize(ProductId constraintAnnotation) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.getProductById(value);
		} catch (ProductNotFoundException e ) {
			return true;
		}
		if (product != null) {
			return false;
		}
		return true;
	}
}