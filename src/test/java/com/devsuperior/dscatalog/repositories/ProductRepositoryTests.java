package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;

@DataJpaTest	
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	private long nonExistingId;
	private long countTotalProducts;
	
	@BeforeEach
	void setUp() {
		exintingId = 1L;
		nonExistingId = 1000L;
		countTotalProducts = 25L;
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducts + 1, product.getId());
	}
	
	@Test	
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(exintingId);
		
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
}
