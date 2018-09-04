package com.webstore.domain.repository.imp;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.webstore.domain.Cart;
import com.webstore.domain.repository.CartRepository;

@Repository
public class InMemoryCartRepository implements CartRepository {
	private Map<String, Cart> listOfCarts;

	public InMemoryCartRepository() {
		listOfCarts = new HashMap<String, Cart>();
	}

	public Cart create(Cart cart) {
		if (listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(
					String.format(
							"Can not create a cart. The basket with the indicated id (%) already exists.",
							cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	public void update(String cartId, Cart cart) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format(
							"The basket can not be updated. The basket with the indicated id (%) does not exist.",
							cartId));
		}
		listOfCarts.put(cartId, cart);
	}

	public void delete(String cartId) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format(
							"The basket can not be removed. The basket with the indicated id (%) does not exist.",
							cartId));
		}
		listOfCarts.remove(cartId);
	}
}
