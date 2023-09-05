package com.ashokit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue
	private Integer prodId;
	private String prodName;
	
	private Double prodCost;
	private String prodColor;
	public Product() {
		super();
	}
	public Product(Integer prodId) {
		super();
		this.prodId = prodId;
	}
	public Product(String prodName, Double prodCost, String prodColor) {
		super();
		this.prodName = prodName;
		this.prodCost = prodCost;
		this.prodColor = prodColor;
	}
	public Product(Integer prodId, String prodName, Double prodCost, String prodColor) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCost = prodCost;
		this.prodColor = prodColor;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	public String getProdColor() {
		return prodColor;
	}
	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + ", prodColor="
				+ prodColor + "]";
	}
	
}
