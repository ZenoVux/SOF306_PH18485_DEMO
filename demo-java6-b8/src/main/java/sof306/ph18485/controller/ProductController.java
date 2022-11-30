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
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/list")
	public String list(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("items", products);
		return "product/list";
	}
	
	@GetMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		model.addAttribute("item", product);
		return "product/detail";
	}
}
