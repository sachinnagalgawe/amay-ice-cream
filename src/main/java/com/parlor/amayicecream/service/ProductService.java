package com.parlor.amayicecream.service;

import java.util.List;

import com.parlor.amayicecream.model.Product;

/**
 * All product related services
 * 
 * @author sachin
 */
public interface ProductService {

	/**
	 * Create Product
	 * 
	 * @return
	 */
	public Product create(Product product);
	
	/**
	 * Fetch all products
	 * 
	 * @return
	 */
	public List<Product> fetchAll();
	
	/**
	 * Import products from CSV file
	 * 
	 */
	public void importFromCsv();
}
