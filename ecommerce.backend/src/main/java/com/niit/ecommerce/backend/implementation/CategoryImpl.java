package com.niit.ecommerce.backend.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.backend.dao.CategoryDao;
import com.niit.ecommerce.backend.model.Category;

@Repository
public class CategoryImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(findById(id));
		session.getTransaction().commit();
		session.close();
	}

	public Category findById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", new Integer(id)));
		List list = criteria.list();
		/*
		 * session.getTransaction().commit(); session.close();
		 */
		if (!list.isEmpty()) {
			return (Category) list.get(0);
		} else {
			return null;
		}

	}

	public List<Category> findAll() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		List<Category> results = query.list();
		System.out.println(results);
		// session.getTransaction().commit();
		return results;
	}

}
