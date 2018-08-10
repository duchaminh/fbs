package com.atom.fbs.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atom.fbs.dao.CategoryDAO;
import com.atom.fbs.dto.Category;

// ko dung annotation ni nhóe :D
@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> loadCategories() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		@SuppressWarnings("unchecked")
		Query<Category> query = getSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Transactional(readOnly = true)
	@Override
	public Category findById(int id) {
		return getSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) throws Exception {
		// ko try catch trong DAO nhé, try-catch ở service á :D
		try {
			// add the category to the database table
			getSession().persist(category);
			return true;
		} catch (Exception e) {
			// xử lý modifier DB như add, update, delete thì ko dc return mà phải throw
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) throws Exception {
		try {
			// add the category to the database table
			getSession().update(category);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean delete(Category category) throws Exception {

		category.setActive(false);
		try {
			// add the category to the database table
			getSession().update(category);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

}
