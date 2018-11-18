package com.webstore.validator;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webstore.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class ProductValidatorTest {
   @Autowired
   private ProductValidator productValidator;
   
   @Test
   public void product_without_UnitPrice_should_be_invalid() {
		//Set.
      Product product = new Product();
      product.setCategory("laptop");
      
      BindException bindException = new BindException(product, "product");
		// Execute.
      ValidationUtils.invokeValidator(productValidator, product, bindException);
      
		// Compare.
      Assert.assertEquals(1, bindException.getErrorCount());
      Assert.assertTrue(bindException.getLocalizedMessage().
      contains("Incorrect product price. Price field can't be empty."));
      

       
   }
   @Test
   public void product_with_existing_productId_invalid() {
		//Set.
      Product product = new Product("P1234","iPhone 5s", new BigDecimal(500));
      product.setCategory("Tablet");
      BindException bindException = new BindException(product, "product");
		// Execute.
      ValidationUtils.invokeValidator(productValidator, product, bindException);
		// Compare.
      Assert.assertEquals(1, bindException.getErrorCount());
      Assert.assertTrue(bindException.getLocalizedMessage().
      contains("The product with the given identifier already exists."));
   }
   @Test
   public void a_valid_product_should_not_get_any_error_during_validation() {
		//Set.
      Product product = new Product("P9876","iPhone 5s", new BigDecimal(500));
      product.setCategory("tablet");
      BindException bindException = new BindException(product, "product");
		// Execute.
      ValidationUtils.invokeValidator(productValidator, product, bindException);
		// Compare.
      Assert.assertEquals(0, bindException.getErrorCount());
   }
}
