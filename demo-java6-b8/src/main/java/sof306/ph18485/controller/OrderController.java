package sof306.ph18485.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sof306.ph18485.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	
	@GetMapping("/order/list")
	public String list(Model model, HttpServletRequest req) {
		String username = req.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}

	@GetMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
	
}
