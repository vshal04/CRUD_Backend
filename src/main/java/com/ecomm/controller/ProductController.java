package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.model.Product;
import com.ecomm.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/addProduct")
	public ResponseEntity<String> saveproduct(@RequestBody Product product) {
		ResponseEntity<String> response = null;
		if (productService.addproduct(product)) {
			response = new ResponseEntity<>(product.toString(), HttpStatus.CREATED);
		}
		return response;

	}

	@GetMapping(path = "/viewAllProduct")
	public ResponseEntity<List<Product>> viewAllProduct() {
		ResponseEntity<List<Product>> response = null;
		List<Product> viewAllProducts = productService.viewAllProducts();
		response = new ResponseEntity<>(viewAllProducts, HttpStatus.OK);
		return response;
	}

	@GetMapping(path = "/viewProductById/{productNo}")
	public ResponseEntity<Product> viewProductById(@PathVariable("productNo") int productNo) {
		ResponseEntity<Product> response = null;
		Product product = productService.viewSingleProduct(productNo);
		if (product != null) {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return response;

	}

	
	@PutMapping(path="/updateProductName/product_NO:{productNo}/name:{productName}")
	public ResponseEntity<String> updateProductName(@PathVariable("productNo") int productNo,@PathVariable("productName") String productName) {
		ResponseEntity<String> response = null;
		if (productService.updateProductName(productNo, productName)) {
			response = new ResponseEntity<String>("Updated name of the product", HttpStatus.OK);
		}
		return response;
	}

	@DeleteMapping(path = "/deleteProductById/{productNo}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productNo") int productNo) {
		ResponseEntity<String> response = null;
		if (productService.deleteProduct(productNo)) {
			response = new ResponseEntity<String>("Product with the given id is deleted", HttpStatus.OK);
		}
		return response;

	}

}
