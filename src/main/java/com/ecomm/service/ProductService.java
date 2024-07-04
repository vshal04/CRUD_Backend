package com.ecomm.service;

import java.util.List;

import com.ecomm.model.Product;

public interface ProductService {
	
	public boolean addproduct(Product product);
	
	public List<Product> viewAllProducts();
	
	public Product viewSingleProduct(int productNo);
	
	public Product updateProduct(String productNo);
	
	public boolean updateProductName(int productNo, String productName);
	
	public boolean deleteProduct(int productNo);

}
