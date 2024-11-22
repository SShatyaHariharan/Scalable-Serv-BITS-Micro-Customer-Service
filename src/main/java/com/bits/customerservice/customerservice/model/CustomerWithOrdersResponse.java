package com.bits.customerservice.customerservice.model;

import java.util.List;

public class CustomerWithOrdersResponse {
    private Long customerId;
    private String name;
    private String email;
    private String address;
    private String contactNumber;
    private List<OrderResponse> orders;
    
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<OrderResponse> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderResponse> orders) {
		this.orders = orders;
	}
    
}