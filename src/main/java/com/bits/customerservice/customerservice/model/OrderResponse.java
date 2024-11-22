package com.bits.customerservice.customerservice.model;

import java.time.OffsetDateTime;
import java.util.List;

public class OrderResponse{
    @Override
	public String toString() {
		return "OrderResponse [id=" + id + ", orderItems=" + orderItems + ", totalOrderPrice=" + totalOrderPrice
				+ ", orderPlacedOn=" + orderPlacedOn + ", orderStatus=" + orderStatus + ", paymentMethod="
				+ paymentMethod + ", deliveryDate=" + deliveryDate + ", shippingAddress=" + shippingAddress + "]";
	}
	private Long id;
    private List<OrderItemResponse> orderItems;
    private Double totalOrderPrice;
    private OffsetDateTime orderPlacedOn;
    private String orderStatus;
    private String paymentMethod;
    private OffsetDateTime deliveryDate;
    private String shippingAddress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderItemResponse> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemResponse> orderItems) {
		this.orderItems = orderItems;
	}
	public Double getTotalOrderPrice() {
		return totalOrderPrice;
	}
	public void setTotalOrderPrice(Double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}
	public OffsetDateTime getOrderPlacedOn() {
		return orderPlacedOn;
	}
	public void setOrderPlacedOn(OffsetDateTime orderPlacedOn) {
		this.orderPlacedOn = orderPlacedOn;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public OffsetDateTime getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(OffsetDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
    
    
}