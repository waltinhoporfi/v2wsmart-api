package com.walter.v2wsmart.DTO;

import com.walter.v2wsmart.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private Long id;
	
	private String name;
	
	private String description;
	
	public CategoryDTO(Category category){
		super();
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
	}
	
}
