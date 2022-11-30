package sof306.ph18485.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import sof306.ph18485.entity.Account;
import sof306.ph18485.entity.Order;
import sof306.ph18485.entity.OrderDetail;
import sof306.ph18485.repository.AccountRepository;
import sof306.ph18485.repository.OrderDetailRepository;
import sof306.ph18485.repository.OrderRepository;
import sof306.ph18485.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderDetailRepository orderDetailRepo;
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public Order findById(Integer id) {
		Optional<Order> optional = orderRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Order create(JsonNode orderJson) {
		ObjectMapper mapper = new ObjectMapper();
		String username = orderJson.get("account").get("username").asText();
		
		Order order = mapper.convertValue(orderJson, Order.class);
		
		Account account = accountRepo.findByUsername(username).get();
		order.setAccount(account);
		
		orderRepo.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> orderDetails = mapper.convertValue(orderJson.get("orderDetails"), type)
				.stream()
				.peek(orderDetail -> orderDetail.setOrder(order))
				.collect(Collectors.toList());
		orderDetailRepo.saveAll(orderDetails);
		return order;
	}

	@Override
	public List<Order> findByUsername(String username) {
		return orderRepo.findByUsername(username);
	}
	
}
