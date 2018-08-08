package com.atom.fbs;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home( Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shop( Model model) {
		return "shop";
	}
	
	@RequestMapping(value = "/cart")
	public String cart( Model model) {
		return "cart";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout( Model model) {
		return "checkout";
	}
	
}
