package sof306.ph18485.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(Integer id);
	Product create(Product product);
	void delete(Integer id);
	
}
