package com.webstore.service;

import com.webstore.domain.Order;

public interface OrderService {

	void processOrder(String productId,int count);
	Long saveOrder(Order order);
}
