package com.walter.v2wsmart.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Long id;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private Category category;
	
}
