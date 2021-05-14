package com.walter.v2wsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walter.v2wsmart.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
