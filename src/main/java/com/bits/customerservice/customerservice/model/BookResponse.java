package com.bits.customerservice.customerservice.model;

public class BookResponse {
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private Double price;
    private Long printYear;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getPrintYear() {
		return printYear;
	}
	public void setPrintYear(Long printYear) {
		this.printYear = printYear;
	}

    // Constructor, Getters, and Setters
    
}
