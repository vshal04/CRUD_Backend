package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "Update Product p Set p.productName = :productName Where p.productNo = :productNo")
	public void editProductName(@Param("productNo") int productNo, @Param("productName") String productName);


}
