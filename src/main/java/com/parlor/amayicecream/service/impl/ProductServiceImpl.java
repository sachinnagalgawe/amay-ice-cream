package com.parlor.amayicecream.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.parlor.amayicecream.model.Product;
import com.parlor.amayicecream.model.Stock;
import com.parlor.amayicecream.repository.ProductRepository;
import com.parlor.amayicecream.service.ProductService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


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
	
	@Value("${excel.file.path}")
	private String excelFilePath;

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
	 * Fetch all products by barcode
	 * 
	 * @return
	 */
	public List<Product> fetchByBarcode(Double barcode) {
		logger.info("Fetching products by barcode: "+barcode);
		return productRepository.findByBarcode(barcode);
	}
	
	/**
	 * Fetch all products by name containing
	 * 
	 * @return
	 */
	public List<Product> fetchByNameContaining(String name) {
		logger.info("Fetching products by name containing: "+name);
		return productRepository.findByDescriptionContainingIgnoreCase(name);
	}

	/**
	 * Import products from CSV file 
	 */
	@Override
	public void importFromCsv() {
		logger.info("Importing products from csv");
		String csvFile = "/home/scriptuit/Desktop/Retailer pricelist Jan2018.xlsx";
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
				//System.out.println("Group: "+country[1]);
				String group = country[1];
				group = group .trim();
				//System.out.println("Description: "+country[2]);
				String description = country[2];
				description = description.trim();
				//System.out.println("Ea: "+country[3]);
				String ea = country[3];
				///System.out.println("MRP: "+country[4]);
				String mrp = country[4];
				//System.out.println("Rtlr Margin: "+country[5]);
				String rtMargin = country[5];
				//System.out.println("Prc to Rtlr with GST: "+country[6]);
				String priceRtMargin = country[6];

				Product product = new Product();
				product.setBarcode(Double.valueOf(barcode));
				product.setDescription(description);
				product.setEa(Double.parseDouble(ea));
				product.setGroup(group);
				product.setMrp(Double.parseDouble(mrp));
				product.setPriceToRtlr(Double.parseDouble(priceRtMargin));
				product.setRtlrMargin(Double.parseDouble(rtMargin));

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

	@Override
	public void readProductsFromExcelFile() throws IOException {
		System.out.println("excelFilePath: "+excelFilePath);
		List<Product> listProducts = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workProduct = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workProduct.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		Stock stock = new Stock();

		int count = 0;

		int productNumber = 0;
		
		while (iterator.hasNext()) {

			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			count++;

			if(count > 1) {
				Product product = new Product();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						Double barcode = (Double) getCellValue(nextCell);
						//System.out.println("barcode: "+barcode.toString());
						product.setBarcode(barcode);
						break;
					case 1:
						product.setGroup(((String) getCellValue(nextCell)).trim());
						break;
					case 2:
						product.setDescription(((String) getCellValue(nextCell)).trim());
						break;
					case 3:
						product.setEa((Double) getCellValue(nextCell));
						break;
					case 4:
						product.setMrp((Double) getCellValue(nextCell));
						break;
					case 5:
						product.setRtlrMargin((Double) getCellValue(nextCell));
						break;
					case 6:
						product.setPriceToRtlr((Double) getCellValue(nextCell));
						break;
					}
				}
				listProducts.add(product);
				
				Product existingProduct = productRepository.findByGroupAndDescription(product.getGroup(), product.getDescription());
				if(existingProduct == null) {
					productNumber++;
					product.setNumber(productNumber);
					product.setStock(stock);
					productRepository.save(product);
				}else {
					//product.setNumber(count);
					//foundProducts.add(existingProduct);
				}

			}
			workProduct.close();
			inputStream.close();
		}
	}

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

}
