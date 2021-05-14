package com.walter.v2wsmart.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	private Long id;

	private String name;

	private String description;

	private List<Product> products;

}
