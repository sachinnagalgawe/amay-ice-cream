package com.parlor.amayicecream;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parlor.amayicecream.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmayicecreamApplicationTests {

	@Autowired
	ProductService productService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() throws IOException {
		productService.readProductsFromExcelFile();
	}
}
