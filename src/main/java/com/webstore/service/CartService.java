package com.webstore.service;

import com.webstore.domain.Cart;


public interface CartService {
	Cart create(Cart cart);

	Cart read(String cartId);
	
	Cart validate(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);
}
