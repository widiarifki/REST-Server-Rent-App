package com.widiarifki.rental.model;

import java.math.BigDecimal;

public class Product {
	
	private int id;
	private String name;
	private BigDecimal charge;
	private int charge_base;
	private String description;
	private String terms;
	private ProductCategory product_category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public int getChargeBase() {
		return charge_base;
	}

	public void setChargeBase(int charge_base) {
		this.charge_base = charge_base;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public ProductCategory getProductCategory() {
		return product_category;
	}

	public void setProductCategory(ProductCategory product_category) {
		this.product_category = product_category;
	}
}