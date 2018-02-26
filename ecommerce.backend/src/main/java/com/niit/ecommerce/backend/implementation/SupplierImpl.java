package com.niit.ecommerce.backend.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecommerce.backend.dao.SupplierDao;
import com.niit.ecommerce.backend.model.Supplier;

@Repository
public class SupplierImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(supplier);
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

	public Supplier findById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Supplier.class);
		criteria.add(Restrictions.eq("id", new Integer(id)));
		List list = criteria.list();
		/*
		 * session.getTransaction().commit(); session.close();
		 */
		if (!list.isEmpty()) {
			return (Supplier) list.get(0);
		} else {
			return null;
		}

	}

	public List<Supplier> findAll() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Supplier";
		Query query = session.createQuery(hql);
		List<Supplier> results = query.list();
		System.out.println(results);
		// session.getTransaction().commit();
		return results;
	}

}