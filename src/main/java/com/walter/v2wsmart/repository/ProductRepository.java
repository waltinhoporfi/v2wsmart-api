package com.walter.v2wsmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.walter.v2wsmart.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT product FROM Product product WHERE product.category.id = :idCategory ORDER BY name")
	List<Product> findAllByCategory(@Param(value = "idCategory") Long idCategory);

}
