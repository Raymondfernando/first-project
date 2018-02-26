package com.niit.ecommerce.backend.dao;

import java.util.List;

import com.niit.ecommerce.backend.model.Products;

public interface ProductsDao {
	void save(Products products);

	void delete(int id);

	Products findById(String id);

	List<Products> findAll();
}