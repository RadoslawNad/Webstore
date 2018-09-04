package com.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class CategoryValidator implements ConstraintValidator<Category, String> {

	List<String> allowedCategories;
	
	public CategoryValidator(){
		allowedCategories=new ArrayList<String>();
		allowedCategories.add("Laptop");
		allowedCategories.add("Tablet");
		
	}
	@Override
	public void initialize(Category arg0) {
		
	}

	@Override
	public boolean isValid(String category, ConstraintValidatorContext arg1) {
		for(String cat:allowedCategories){
			if(cat.equalsIgnoreCase(category)){
				return true;
			}
		}
		return false;
	}

}
