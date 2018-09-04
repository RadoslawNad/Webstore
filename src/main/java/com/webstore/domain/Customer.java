package com.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = -1455449666851519938L;
	private String customerId;
	private String name;
	private String address;
	private String noOfOrderMade;
	private Address billingAddress;
	private String phoneNumber;
	
	
	
	public Customer() {
		super();
		this.billingAddress = new Address();
	}
	
	public Customer(String customerId, String name, String adress) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = adress;
	}
	
	public Customer(String customerId, String name) {
		this();
		this.customerId = customerId;
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNoOfOrderMade() {
		return noOfOrderMade;
	}

	public void setNoOfOrderMade(String noOfOrderMade) {
		this.noOfOrderMade = noOfOrderMade;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((noOfOrderMade == null) ? 0 : noOfOrderMade.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfOrderMade == null) {
			if (other.noOfOrderMade != null)
				return false;
		} else if (!noOfOrderMade.equals(other.noOfOrderMade))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	

	
	
	
}
