package com.nissan.model;

public class Category {

	//instance variables
	private int categoryIdNew;
	private static int categoryId = 1;
	private String categoryName;
	private float tax;
	
	//default constructor
	public Category() {
		
	}
	
	//parameterized constructor
	public Category(String categoryName, float tax) {
		this.categoryIdNew = categoryId++;
		this.categoryName = categoryName;
		this.tax = tax;
	}

	//getters and setters
	public int getCategoryId() {
		return categoryIdNew;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	//toString() method
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", tax=" + tax + "]";
	}

}
