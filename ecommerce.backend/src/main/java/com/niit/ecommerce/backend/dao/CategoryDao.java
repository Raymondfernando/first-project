package com.niit.ecommerce.backend.dao;

import java.util.List;

import com.niit.ecommerce.backend.model.Category;

public interface CategoryDao {
	void save(Category category);

	void delete(int id);

	Category findById(int id);

	List<Category> findAll();
}