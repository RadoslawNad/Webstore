package com.webstore.domain.repository.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductsRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();

	public InMemoryProductsRepository() {
		Product iphone = new Product("P1234", "iPhone X", new BigDecimal(4700));
		iphone.setDescription("Smartfon Apple iPhone X 64GB Silver");
		iphone.setCategory("Smartfon");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(200);

		Product laptopDell = new Product("P5678", "HP Omen",
				new BigDecimal(4100));
		laptopDell.setDescription("Laptop 15.6'' FHDmatt IPS LED/i7/8GB/1TB/HD630+GTX 1050Ti_4GB/USB3/USB-C/HDMI/BT/11hPRACY/Windows 10 PMG");
		laptopDell.setCategory("laptops");
		laptopDell.setManufacturer("HP");
		laptopDell.setUnitsInStock(100);

		Product tabletNexus = new Product("P9012", " AGLE 804",
				new BigDecimal(320));
		tabletNexus.setDescription("Tablet Kruger&Matz EAGLE 804 8' 3G Black");
		tabletNexus.setCategory("tablets");
		tabletNexus.setManufacturer("Kruger&Matz");
		tabletNexus.setUnitsInStock(700);

		listOfProducts.add(iphone);
		listOfProducts.add(laptopDell);
		listOfProducts.add(tabletNexus);

	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;
		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null
					&& product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		if (productById == null) {
			throw new ProductNotFoundException(productId);
		}
		return productById;
	}

	public List<Product> getProductByCategory(String category) {
		List<Product> productByCategory = new ArrayList<Product>();
		for (Product product : listOfProducts) {
			if (category.equalsIgnoreCase(product.getCategory())) {
				productByCategory.add(product);
			}
		}
		return productByCategory;
	}

	public Set<Product> getProductByFilter(
			Map<String, List<String>> filterParams) {

		Set<Product> productByBrand = new HashSet<Product>();
		Set<Product> productByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productByBrand.add(product);
					}

				}
			}

		}
		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productByCategory.addAll(this.getProductByCategory(category));
			}
		}
		productByCategory.retainAll(productByBrand);

		return productByCategory;
	}

	public void addProduct(Product product) {
		listOfProducts.add(product);
	}

}
