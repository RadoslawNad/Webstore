package com.webstore.domain;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
	private Cart cart;
	
	@Before
	public void setup() {
		cart = new Cart();
	}
	
	@Test
	public void cart_grand_total_price_should_be_eaual_to_sum_of_two_products_unit_price_in_case_of_single_quantity() {
		//Set.
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		Product tablet = new Product("P8874", "Tablet T1", new BigDecimal(200));
		CartItem cartItemA=new CartItem(iphone);
		CartItem cartItemB=new CartItem(tablet);
		cart.addCartItem(cartItemA);
		cart.addCartItem(cartItemB);
		
		// Execute.
		BigDecimal grandTotal = cart.getGrandTotal();
		BigDecimal sum = iphone.getUnitPrice().add(tablet.getUnitPrice());
				 
		// Compare.
		Assert.assertEquals(sum, grandTotal);
	}
}
