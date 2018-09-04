package com.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}

	public Set<Product> getProductByFilter(
			Map<String, List<String>> filterParams) {
		return productRepository.getProductByFilter(filterParams);
	}

	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
	
	

}
