package com.walter.v2wsmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.walter.v2wsmart.DTO.CategoryDTO;
import com.walter.v2wsmart.domain.Category;
import com.walter.v2wsmart.exception.CategoryException;
import com.walter.v2wsmart.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		
		return category.orElseThrow(() -> new CategoryException(
				"Categoria não encontrada"));
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category create(Category category) {
		category.setId(null);
		return categoryRepository.save(category);
	}

	public Category update(Long id, CategoryDTO categoryDTO) {
		Category category = findById(id);
		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());
		return categoryRepository.save(category);
	}

	public void delete(Long id) {
		findById(id);
		try {
			categoryRepository.deleteById(id);	
		} catch (DataIntegrityViolationException e) {
			throw new com.walter.v2wsmart.exception.DataIntegrityViolationException
			("Esta categoria possui produtos associados, por isso não pode ser deletada");
		}		
	}
	
}
