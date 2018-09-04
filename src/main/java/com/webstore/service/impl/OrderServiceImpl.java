package com.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.domain.Order;
import com.webstore.domain.Product;
import com.webstore.domain.repository.OrderRepository;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.CartService;
import com.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductRepository productRepository;

	public void processOrder(String productId, int count) {

		Product productById = productRepository.getProductById(productId);
		if (productById.getUnitsInStock() < count) {
			throw new IllegalArgumentException(
					"No item currently in stock:"
							+ productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

	public Long saveOrder(Order order) {
		Long orderId = orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}

}
