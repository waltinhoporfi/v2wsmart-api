package com.walter.v2wsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walter.v2wsmart.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
