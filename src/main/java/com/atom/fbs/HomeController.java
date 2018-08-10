package com.atom.fbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atom.fbs.dao.CategoryDAO;
import com.atom.fbs.dao.ProductDAO;
import com.atom.fbs.dto.Category;
import com.atom.fbs.dto.Product;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("products", productDAO.loadProducts());
		return mv;
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop(Model model) {
		ModelAndView mv = new ModelAndView("shop");
		mv.addObject("categories", categoryDAO.loadCategories());
		mv.addObject("products", productDAO.loadProducts());
		return mv;
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		return "cart";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(Model model) {
		return "checkout";
	}

	@RequestMapping(value = "/shop/category/{id}/products", method = RequestMethod.GET)
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("shop");

		Category category = null;
		category = categoryDAO.findById(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.loadCategories());
		mv.addObject("products", productDAO.listActiveProductsByCategory(id));
		mv.addObject("category", category);
		return mv;
	}

	@RequestMapping(value = "/show/{id}/product", method = RequestMethod.GET)
	public ModelAndView showDetailsProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("product-details");
		Product product = productDAO.findById(id);
		mv.addObject("product", product);
		return mv;
	}

}
