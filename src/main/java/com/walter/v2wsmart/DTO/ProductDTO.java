package com.walter.v2wsmart.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import com.walter.v2wsmart.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable{

	private static final long serialVersionUID = -6938576299077692124L;

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	public ProductDTO(Product product) {
		super();
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}
	
}
