package com.webstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class CartRestControllerTest {
	@Autowired
	Product product;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	MockHttpSession session;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		product=new Product("P6666","Lenovo",new BigDecimal(999),"laptop");
		productRepository.addProduct(product);
	}

	@Test
	public void read_method_should_return_correct_cart_Json_object()
			throws Exception {
		// Ustaw.
		this.mockMvc.perform(put("/rest/cart/add/P6666").session(session))
				.andExpect(status().is(204));
		// Wykonaj.
		this.mockMvc
				.perform(get("/rest/cart/" + session.getId()).session(session))
				.andExpect(status().isOk())
				.andExpect(
						jsonPath("$.cartItems.P6666.product.productId").value(
								"P6666"));
	}
}