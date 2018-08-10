package com.atom.fbs.dao;

import java.util.List;

import com.atom.fbs.dto.Category;

public interface CategoryDAO {
	Category findById(int id);
	List<Category> loadCategories();
	boolean add(Category category) throws Exception ;
	boolean update(Category category) throws Exception;
	boolean delete(Category category) throws Exception;
}
