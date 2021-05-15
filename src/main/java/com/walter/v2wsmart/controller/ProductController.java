package com.walter.v2wsmart.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walter.v2wsmart.DTO.ProductDTO;
import com.walter.v2wsmart.domain.Product;
import com.walter.v2wsmart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productService.findAll();
		return ResponseEntity.ok().body(products);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(product);
	}

	@GetMapping("/byCategory")
	public ResponseEntity<List<ProductDTO>> findAllByCategory(
			@RequestParam(value = "category", defaultValue = "0") Long idCategory) {
		List<Product> products = productService.findAllByCategory(idCategory);
		List<ProductDTO> productsDTO = products.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(productsDTO);

	}

}
