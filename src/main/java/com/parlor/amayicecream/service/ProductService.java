package com.parlor.amayicecream.service;

import java.io.IOException;
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
	 * Fetch all products by barcode
	 * 
	 * @return
	 */
	public List<Product> fetchByBarcode(Double barcode);
	
	/**
	 * Fetch all products by name containing
	 * 
	 * @return
	 */
	public List<Product> fetchByNameContaining(String name);
	
	/**
	 * Fetch all products by margin
	 * 
	 * @return
	 */
	public List<Product> fetchByMargin();
	
	/**
	 * Fetch all products low stock
	 * 
	 * @return
	 */
	public List<Product> fetchByStock();
	
	/**
	 * Import products from CSV file
	 * 
	 */
	public void importFromCsv();
	
	/**
	 * Import excel file
	 */
	public void readProductsFromExcelFile() throws IOException;
}
