package com.walter.v2wsmart.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.walter.v2wsmart.DTO.CategoryDTO;
import com.walter.v2wsmart.domain.Category;
import com.walter.v2wsmart.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<Category> categories = categoryService.findAll();
		List<CategoryDTO> categoriesDTO = categories.stream().
				map(category -> new CategoryDTO(category)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriesDTO);
	}
	
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category category){
		
		category = categoryService.create(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> 
	update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
		Category category = categoryService.update(id, categoryDTO);
		return ResponseEntity.ok().body(new CategoryDTO(category));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
