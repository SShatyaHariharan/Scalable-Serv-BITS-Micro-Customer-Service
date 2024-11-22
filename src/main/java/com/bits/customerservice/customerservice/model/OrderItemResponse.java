package com.bits.customerservice.customerservice.model;

public class OrderItemResponse {
    private Long id;
    private BookResponse book;
    private Long quantity;
    private Double totalPrice;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BookResponse getBook() {
		return book;
	}
	public void setBook(BookResponse book) {
		this.book = book;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
}