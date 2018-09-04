package com.webstore.domain;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartItemTest {
	private CartItem cartItem;

	@Before
	public void setup() {
		cartItem = new CartItem();
	}

	@Test
	public void cartItem_total_price_should_be_eaual_to_product_unit_price_in_case_of_single_quantity() {
		//Set.
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		cartItem.setProduct(iphone);
		// Execute.
		BigDecimal totalPrice = cartItem.getTotalPrice();
		// Compare.
		Assert.assertEquals(iphone.getUnitPrice(), totalPrice);
	}
}