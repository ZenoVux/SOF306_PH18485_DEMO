package sof306.ph18485.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sof306.ph18485.entity.Product;
import sof306.ph18485.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		if (product == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
//		Product product = productService.getById(id);
//		if (product == null) {
//			return ResponseEntity.badRequest().build();
//		}
		return productService.create(product);
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
		return productService.create(product);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
	
}
