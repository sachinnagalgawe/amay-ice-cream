package com.parlor.amayicecream.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.parlor.amayicecream.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

	public Product findByGroupAndDescription(String group, String description);
}
