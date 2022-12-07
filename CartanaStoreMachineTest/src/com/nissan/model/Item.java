package com.nissan.model;

public class Item {

	//instance variables
	private int itemCodeNew;
	private static int itemCode = 1;
	private String itemName;
	private double buyingPrice;
	private double sellingPrice;
	private int quantity;
	private int categoryId;
	
	//default constructor
	public Item() {
		
	}

	//parameterized constructor
	public Item(String itemName, double buyingPrice, double sellingPrice, int quantity, int categoryId) {
		this.itemCodeNew = itemCode++;
		this.itemName = itemName;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}

	//getters and setters
	public int getItemCode() {
		return itemCodeNew;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	//toString() method
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice
				+ ", quantity=" + quantity + ", categoryId=" + categoryId + "]";
	}

}
