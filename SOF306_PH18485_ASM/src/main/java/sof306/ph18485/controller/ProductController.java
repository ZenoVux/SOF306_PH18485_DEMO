package sof306.ph18485.controller;

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
	
	@GetMapping("/product/{code}")
	public String detail(Model model, @PathVariable("code") String code) {
		Product product = productService.findByCode(code);
		model.addAttribute("item", product);
		return "product/detail";
	}
}
