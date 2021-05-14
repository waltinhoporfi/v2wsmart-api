package com.walter.v2wsmart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.walter.v2wsmart.domain.Category;
import com.walter.v2wsmart.domain.Product;
import com.walter.v2wsmart.repository.CategoryRepository;
import com.walter.v2wsmart.repository.ProductRepository;

@SpringBootApplication
public class V2wsmartApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(V2wsmartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		
		ArrayList<Product> products = new ArrayList<>();
		
		Category category = new Category(null, "iPhones", "Smartphones Apple", products);
		
		Product product = new Product(null, "iPhones 7", "iPhone 7 128GB", BigDecimal.valueOf(1600), category);
		
		category.getProducts().addAll(Arrays.asList(product));
		
		categoryRepository.saveAll(Arrays.asList(category));
		productRepository.saveAll(Arrays.asList(product));
		
	}

}
