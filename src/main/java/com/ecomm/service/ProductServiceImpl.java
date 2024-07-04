package com.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecomm.model.Product;
import com.ecomm.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	public static void add(){
		String "add";
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean addproduct(Product product) {

		boolean result = false;
		if (product.getProductName() != null || product.getProductNo() != 0 || product.getProductCost() != 0
				|| product.getProductDescription() != null) {

			productRepository.save(product);
			System.out.println("productRepository: " + productRepository);
			result = true;

		}

		return result;
	}

	@Override
	public List<Product> viewAllProducts() {

		List<Product> allproduct = productRepository.findAll();

		return allproduct;
	}

	@Override
	public Product viewSingleProduct(int productNo) {

		Product result = null;

		if (productRepository.existsById(productNo)) {
			result = productRepository.findById(productNo).get();
		}

		return result;
	}

	@Override
	public Product updateProduct(String productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProductName(int productNo, String productName) {

		if (productRepository.existsById(productNo)) {
			productRepository.editProductName(productNo, productName);
		}
		return true;
	}

	@Override
	public boolean deleteProduct(int productNo) {
		if (productRepository.existsById(productNo)) {
			productRepository.deleteById(productNo);
		}

		return true;
	}

}
