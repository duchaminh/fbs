package com.atom.fbs.dao;

import java.util.List;

import com.atom.fbs.dto.Product;

public interface ProductDAO {

	Product findById(int productId);

	List<Product> loadProducts();

	boolean add(Product product) throws Exception;

	boolean update(Product product) throws Exception;

	boolean delete(Product product) throws Exception;

	List<Product> getProductsByParam(String param, int count);

	// business methods
	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLatestActiveProducts(int count);

}
