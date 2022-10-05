package org.itsci.fishshop.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.itsci.fishshop.model.Address;
import org.itsci.fishshop.model.Categories;
import org.itsci.fishshop.model.Login;
import org.itsci.fishshop.model.News;
import org.itsci.fishshop.model.Orders;
import org.itsci.fishshop.model.Order_Detail;
import org.itsci.fishshop.model.Payment;
import org.itsci.fishshop.model.Product;
import org.itsci.fishshop.model.Register;



public class HibernateConnection {
	public static SessionFactory sessionFactory;
	
	public static SessionFactory doHibernateConnection() {
		Properties database = new Properties();
		database.setProperty("hibernate.hbm2ddl.auto", "create");
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "root");
		database.setProperty("hibernate.connection.password", "1234");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/project_web");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		Configuration cfg = new Configuration().setProperties(database).addPackage("model")
				.addAnnotatedClass(Login.class) .addAnnotatedClass(Register.class).addAnnotatedClass(Orders.class)
				.addAnnotatedClass(News.class)
				.addAnnotatedClass(Address.class).addAnnotatedClass(Payment.class) .addAnnotatedClass(Categories.class)
				.addAnnotatedClass(Order_Detail.class) .addAnnotatedClass(Product.class);
				 

		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		return sessionFactory;
	}

	

}
