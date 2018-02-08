package com.parlor.amayicecream.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parlor.amayicecream.model.Product;
import com.parlor.amayicecream.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	// Declare the Logger
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Create Product
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		logger.info("Creating product");
		Product createdProduct = productService.create(product);
		return createdProduct;
	}
	
	/**
	 * Get all Products
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		logger.info("Get all Products");
		List<Product> allProducts = productService.fetchAll();
		return allProducts;
	}
}
