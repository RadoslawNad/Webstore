package com.webstore.domain.repository;

import com.webstore.domain.Cart;

public interface CartRepository {
	Cart create(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);
}
