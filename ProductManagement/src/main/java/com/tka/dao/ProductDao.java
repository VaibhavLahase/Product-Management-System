package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private SessionFactory sessionfactory;

	public String addProduct(Product product) {
		
		try {
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit(); 
			return "product addes Successfully in db table";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return "Something went Wrong";
		}
	}

	public List<Product> displayProduct() {
		List<Product> plist = null;
		try {
			Session session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			plist = criteria.list();

			return plist;
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Something went Wrong";
			return plist;
		}
	}

	public Product getProduct(int pk) {
		
		System.out.println("we are in get product dao");
		Product product = null;
		try {
			Session session = sessionfactory.openSession();
			product = session.get(Product.class, pk);
	
			return product;
		} catch (Exception e) {
			e.printStackTrace();

			return product;
		}
	}

	public String deleteProduct(int pk) {
		
		System.out.println("we are in delete product dao");

		try {
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			Product product = session.get(Product.class, pk);
			session.delete(product);
			tx.commit();

			return "Product deleted from db";

		} catch (Exception e) {
			e.printStackTrace();

			return "Something went Wrong";
		}
	}

	public String updateProduct(Product product) {
		try {
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(product);
			tx.commit(); 
			return "product updated Successfully in db table";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return "Something went Wrong";
		}
		
	}

}
