package com.walter.v2wsmart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.v2wsmart.domain.Category;
import com.walter.v2wsmart.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
}
