package com.dreamhaat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartID;
	
	@Column
	private int pid;
	
	@Column
	private float price;
	
	@Column
	private int stock;
	@Column
	private String name;
	@Column
	private float total;
	@Column
	private int qty=1;
	@Column
	private int orderID;


	
public Cart()
{}



public int getCartID() {
	return cartID;
}



public void setCartID(int cartID) {
	this.cartID = cartID;
}



public int getPid() {
	return pid;
}



public void setPid(int pid) {
	this.pid = pid;
}



public float getPrice() {
	return price;
}



public void setPrice(float price) {
	this.price = price;
}



public int getStock() {
	return stock;
}



public void setStock(int stock) {
	this.stock = stock;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public float getTotal() {
	return total;
}



public void setTotal(float total) {
	this.total = total;
}



public int getQty() {
	return qty;
}



public void setQty(int qty) {
	this.qty = qty;
}



public int getOrderID() {
	return orderID;
}



public void setOrderID(int orderID) {
	this.orderID = orderID;
}


}