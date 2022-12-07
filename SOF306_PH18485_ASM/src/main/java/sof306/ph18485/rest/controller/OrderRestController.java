package sof306.ph18485.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import sof306.ph18485.entity.Order;
import sof306.ph18485.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public Order create(@RequestBody JsonNode orderJson) {
		return orderService.create(orderJson);
	}
	
	@GetMapping("/{id}")
	public Order findById(@PathVariable("id") Integer id) {
		return orderService.findById(id);
	}
}
