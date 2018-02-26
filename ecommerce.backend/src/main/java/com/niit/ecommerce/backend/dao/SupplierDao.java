package com.niit.ecommerce.backend.dao;

import java.util.List;

import com.niit.ecommerce.backend.model.Supplier;

public interface SupplierDao {
	void save(Supplier supplier);

	void delete(int id);

	Supplier findById(int id);

	List<Supplier> findAll();
}