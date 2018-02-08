package com.parlor.amayicecream.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parlor.amayicecream.controller.ProductController;
import com.parlor.amayicecream.model.Product;
import com.parlor.amayicecream.repository.ProductRepository;
import com.parlor.amayicecream.service.ProductService;

/**
 * ProductServiceImpl class for implementation
 * of Product Service
 * 
 * @author sachin
 */
@Service
public class ProductServiceImpl implements ProductService{

	// Declare the Logger
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Create Product
	 * 
	 * @return
	 */
	@Override
	public Product create(Product product) {
		logger.info("Creating new product");
		Product createdProduct = productRepository.save(product);
		return createdProduct;
	}

	/**
	 * Fetch all products
	 * 
	 * @return
	 */
	@Override
	public List<Product> fetchAll() {
		logger.info("Fetching all products");
		return productRepository.findAll();
	}

	/**
	 * Import products from CSV file 
	 */
	@Override
	public void importFromCsv() {
		logger.info("Importing products from csv");
		String csvFile = "/home/scriptuit/Desktop/Retailer pricelist Jan2018.csv";
		String line = "";
		String cvsSplitBy = ",";

		List<Product> foundProducts = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			int count = 0;
			int iteration = 0;
			while ((line = br.readLine()) != null) {

				if(iteration == 0) {
			        iteration++;  
			        continue;
			    }
				
				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				//System.out.println("Product [barcode= " + country[0] + " , name=" + country[1] + "]");
				System.out.println("Barcode"+country[0]);
				String barcode = country[0];
				System.out.println("Group: "+country[1]);
				String group = country[1];
				group = group .trim();
				System.out.println("Description: "+country[2]);
				String description = country[2];
				description = description.trim();
				System.out.println("Ea: "+country[3]);
				String ea = country[3];
				System.out.println("MRP: "+country[4]);
				String mrp = country[4];
				System.out.println("Rtlr Margin: "+country[5]);
				String rtMargin = country[5];
				System.out.println("Prc to Rtlr with GST: "+country[6]);
				String priceRtMargin = country[6];
				
				Product product = new Product();
				product.setBarcode(barcode);
				product.setDescription(description);
				product.setEa(Float.parseFloat(ea));
				product.setGroup(group);
				product.setMrp(Float.parseFloat(mrp));
				product.setPriceToRtlr(Float.parseFloat(priceRtMargin));
				product.setRtlrMargin(Float.parseFloat(rtMargin));
				
				Product existingProduct = productRepository.findByGroupAndDescription(group, description);
				if(existingProduct == null) {
					count ++;
					product.setNumber(count);
					productRepository.save(product);
				}else {
					//product.setNumber(count);
					foundProducts.add(existingProduct);
				}
				System.out.println("---------------------------------------");
			}
			
			for(Product p : foundProducts) {
				System.out.println("Product found: "+p.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
