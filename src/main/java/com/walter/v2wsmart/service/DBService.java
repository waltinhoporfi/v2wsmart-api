package com.walter.v2wsmart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.v2wsmart.domain.Category;
import com.walter.v2wsmart.domain.Product;
import com.walter.v2wsmart.repository.CategoryRepository;
import com.walter.v2wsmart.repository.ProductRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public void dataBase() {

		ArrayList<Product> products = new ArrayList<>();

		Category category1 = new Category(null, "SmartPhones", "Apple ou Xiaomi", products);
		Category category2 = new Category(null, "Fones", "Airdots ou  Airpods", products);
		Category category3 = new Category(null, "SmartWatches", "Apple Watch ou Amazfit", products);

		Product product1 = new Product(null, "iPhones 7", "iPhone 7 128GB", BigDecimal.valueOf(1600), category1);
		Product product2 = new Product(null, "iPhones 8", "iPhone 8 64GB", BigDecimal.valueOf(1600), category1);
		Product product3 = new Product(null, "Airdots 2", "Airdots 2 Bluetooth", BigDecimal.valueOf(1600), category2);
		Product product4 = new Product(null, "AirPods Pro", "AirPods Pro Bluetooth", BigDecimal.valueOf(1600),
				category2);
		Product product5 = new Product(null, "Amazfit Bip", "Amazfit Bip Lite", BigDecimal.valueOf(1600), category3);
		Product product6 = new Product(null, "Apple Watch S6", "Apple Watch S6 Black", BigDecimal.valueOf(1600),
				category3);

		category1.getProducts().addAll(Arrays.asList(product1, product2));
		category2.getProducts().addAll(Arrays.asList(product3, product4));
		category3.getProducts().addAll(Arrays.asList(product5, product6));

		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6));

	}

}
