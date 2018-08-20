package com.atom.fbs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atom.fbs.dao.CategoryDAO;
import com.atom.fbs.dao.ProductDAO;
import com.atom.fbs.dto.Category;
import com.atom.fbs.dto.Product;
import com.atom.util.FileUtil;
import com.atom.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("manageProduct");
		Product product = new Product();

		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		product.setSupplierId(1);
		product.setActive(true);
		mv.addObject("product", product);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully!");
			} else if (operation.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}

		return mv;

	}

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.loadCategories();
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) throws Exception {
		if (mProduct.getId() == 0
				|| (mProduct.getFile() != null && StringUtils.isEmpty(mProduct.getFile().getOriginalFilename()))) {
			new ProductValidator().validate(mProduct, results);
		}

		if (results.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the product!");
			return "manageProduct";
		}

		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {
			productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/product?operation=product";
	}

	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();

	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category mCategory) throws Exception {
		categoryDAO.add(mCategory);
		return "redirect:/manage/product?operation=category";
	}

	@RequestMapping("/{id}/product")
	public ModelAndView manageProductEdit(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("manageProduct");

		Product nProduct = productDAO.findById(id);
		mv.addObject("product", nProduct);

		return mv;

	}
}