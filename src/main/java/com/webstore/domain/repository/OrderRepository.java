package com.webstore.domain.repository;

import com.webstore.domain.Order;

public interface OrderRepository {

	Long saveOrder(Order order);
}
