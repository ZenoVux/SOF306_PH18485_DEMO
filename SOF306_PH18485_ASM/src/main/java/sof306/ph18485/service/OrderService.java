package sof306.ph18485.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import sof306.ph18485.entity.Order;

public interface OrderService {
	
	List<Order> findAll();
	List<Order> findByUsername(String username);
	Order findById(Integer id);
	Order create(JsonNode node);
	
}
