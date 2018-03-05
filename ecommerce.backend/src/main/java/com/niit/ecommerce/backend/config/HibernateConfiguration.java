package com.niit.ecommerce.backend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.criteria.CriteriaQuery;

import com.niit.ecommerce.backend.model.Category;
import com.niit.ecommerce.backend.model.Products;
import com.niit.ecommerce.backend.model.Supplier;
import com.niit.ecommerce.backend.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.niit.ecommerce.backend.model.Users")
public class HibernateConfiguration {

	@Bean(name = "datasource")
	public static DataSource getDatasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		// com.mysql.jdbc.Driver
		// oracle.jdbc.driver.OracleDriver
		datasource.setDriverClassName("org.h2.Driver");
		// jdbc:oracle:thin:@localhost:1521:SID
		// jdbc:mysql://localhost:3306/test
		datasource.setUrl("jdbc:h2:tcp://localhost/~/myshopee");
		datasource.setUsername("sa");
		datasource.setPassword("");
		return datasource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");// optional
		properties.put("hibernate.format_sql", "true");// optional
		// properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");// must
		properties.put("hibernate.hbm2ddl.auto", "update");// must
		return properties;
	}

	@Autowired
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);// maps the class with table
		sessionBuilder.addAnnotatedClass(Category.class);// maps the class with table
		sessionBuilder.addAnnotatedClass(Supplier.class);// maps the class with table
		sessionBuilder.addAnnotatedClass(Products.class);// maps the class with table


		return sessionBuilder.buildSessionFactory();
	}
}