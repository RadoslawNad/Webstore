package com.webstore.domain.repository.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.webstore.domain.Customer;
import com.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();

	public InMemoryCustomerRepository() {

		Customer radek=new Customer("1","Radek","Lublin");
		radek.setNoOfOrderMade("5824");
		
		Customer piotrek=new Customer("2","Piotrek","Warszawa");
		piotrek.setNoOfOrderMade("4872k");
		
		Customer karol=new Customer("3","Karol","Gdansk");
		karol.setNoOfOrderMade("3382z");

		listOfCustomers.add(karol);
		listOfCustomers.add(piotrek);
		listOfCustomers.add(radek);
	}

	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

}
