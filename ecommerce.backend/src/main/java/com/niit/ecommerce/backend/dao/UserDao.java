package com.niit.ecommerce.backend.dao;

import java.util.List;

import com.niit.ecommerce.backend.model.User;

public interface UserDao {
	void save(User user);

	void delete(int id);

	User findById(int id);

	List<User> findAll();
}