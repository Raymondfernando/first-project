package com.niit.ecommerce.backend.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.backend.dao.UserDao;
import com.niit.ecommerce.backend.model.User;

@Repository
public class UserImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {

	}

	public User findById(int id) {
		return null;
	}

	public List<User> findAll() {
		return null;
	}
}