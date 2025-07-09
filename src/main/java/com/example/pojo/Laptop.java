package com.example.pojo;

public class Laptop {

	private int number;
	private String brand;
	private int price;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [number=" + number + ", brand=" + brand + ", price=" + price + "]";
	}
	
}
