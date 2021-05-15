package com.walter.v2wsmart.DTO;

import java.io.Serializable;

import com.walter.v2wsmart.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 4923054543240258491L;
	
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
