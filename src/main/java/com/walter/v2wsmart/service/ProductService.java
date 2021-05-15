package com.walter.v2wsmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.v2wsmart.domain.Product;
import com.walter.v2wsmart.exception.ProductException;
import com.walter.v2wsmart.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Product update(Long id, Product product) {
		Product newProduct = findById(id);
		updateData(newProduct, product);
		return productRepository.save(newProduct);
	}

	private void updateData(Product newProduct, Product product) {
		newProduct.setName(product.getName());
		newProduct.setDescription(product.getDescription());
		newProduct.setPrice(product.getPrice());
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new ProductException("Produto não encontrado"));
	}

	public List<Product> findAllByCategory(Long idCategory) {
		categoryService.findById(idCategory);
		return productRepository.findAllByCategory(idCategory);
		
	}

}
