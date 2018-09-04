package com.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.webstore.domain.Product;

public interface ProductService {

	List<Product>getAllProducts();
	Product getProductById(String productId);
	List<Product>getProductByCategory(String category);
	Set<Product> getProductByFilter(Map<String, List<String>> filterParams);
	void addProduct(Product product);
}
