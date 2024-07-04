package com.ecomm.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component("Product")
@Scope(scopeName = "prototype")
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCT_NAME", length = 50, nullable = false)
	private String productName;

	@Id
	@Column(name = "PRODUCT_NO", length = 50, nullable = false)
	private int productNo;

	@Column(name = "PRODUCT_DESC", length = 50, nullable = false)
	private String productDescription;

	@Column(name = "PRODUCT_COST", length = 50, nullable = false)
	private double productCost;

	public Product() {

	}

	public Product(String productName, int productNo, String productDescription, double productCost) {
		super();
		this.productName = productName;
		this.productNo = productNo;
		this.productDescription = productDescription;
		this.productCost = productCost;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productNo=" + productNo + ", productDescription="
				+ productDescription + ", productCost=" + productCost + "]";
	}

}
