package com.walter.v2wsmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.v2wsmart.domain.Category;
import com.walter.v2wsmart.domain.Product;
import com.walter.v2wsmart.exception.ProductException;
import com.walter.v2wsmart.exception.ProductInvalidException;
import com.walter.v2wsmart.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Product create(Long idCategory, Product product) {	
		validateProduct(product);
		Category category = categoryService.findById(idCategory);
		product.setId(null);
		product.setCategory(category);
		return productRepository.save(product);
	}	
	
	public Product update(Long id, Product product) {
		validateProduct(product);
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

	public void delete(Long id) {
		Product product = findById(id);
		productRepository.delete(product);
	}
	
	public void validateProduct(Product product) {
		if(product.getName() == null) {
			throw new ProductInvalidException("Por favor informar o nome do produto");
		}
		if(product.getDescription() == null) {
			throw new ProductInvalidException("Por favor informar a descrição do produto");
		}
		if(product.getPrice() == null) {
			throw new ProductInvalidException("Por favor informar o preço do produto");
		}
	}

}
