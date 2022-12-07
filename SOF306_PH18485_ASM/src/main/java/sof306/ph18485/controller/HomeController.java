package sof306.ph18485.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sof306.ph18485.entity.Product;
import sof306.ph18485.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("items", products);
		return "product/list";
	}
	
	@GetMapping("/category/{category-code}")
	public String list(Model model, @PathVariable("category-code") String categoryCode) {
		List<Product> products = productService.findByCategoryCode(categoryCode);
		model.addAttribute("items", products);
		return "product/list";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/index";
	}
}
