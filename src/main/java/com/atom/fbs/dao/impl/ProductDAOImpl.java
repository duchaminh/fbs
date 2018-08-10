package com.atom.fbs.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atom.fbs.dao.ProductDAO;
import com.atom.fbs.dto.Product;

// fix tơơng tự file kia nhé :D
@Transactional
@Repository("productDAO")

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * SINGLE
	 */
	@Transactional(readOnly = true)
	@Override
	public Product findById(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * LIST
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Product> loadProducts() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	/*
	 * INSERT
	 */
	@Override
	public boolean add(Product product) throws Exception {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * UPDATE
	 */
	@Override
	public boolean update(Product product) throws Exception {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * DELETE
	 */
	@Override
	public boolean delete(Product product) throws Exception {
		try {

			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception e) {
			throw e;
		}

	}
	@Transactional(readOnly = true)
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Product> getProductsByParam(String param, int count) {

		String query = "FROM Product WHERE active = true ORDER BY " + param + " DESC";

		return sessionFactory.getCurrentSession().createQuery(query, Product.class).setFirstResult(0)
				.setMaxResults(count).getResultList();

	}

}
