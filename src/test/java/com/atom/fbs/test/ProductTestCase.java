package com.atom.fbs.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atom.fbs.dao.ProductDAO;
import com.atom.fbs.dto.Product;


public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.atom.fbs");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() throws Exception {
		
		// create operation
		product = new Product();
				
		product.setName("chuyen cua pi");
		product.setBrand("Kim Dong");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(1);
		
		try {
			assertEquals("Something went wrong while inserting a new product!",
					true,productDAO.add(product));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		// list
		assertEquals("Something went wrong while fetching the list of products!",
				6,productDAO.loadProducts().size());		
				
	}
			
	
	/*@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} 
	
	*/
	
		
}
