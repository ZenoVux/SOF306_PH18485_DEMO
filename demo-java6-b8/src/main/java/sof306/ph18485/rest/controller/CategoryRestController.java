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

import sof306.ph18485.entity.Category;
import sof306.ph18485.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Category> getById(@PathVariable("id") Integer id) {
//		Product product = productService.findById(id);
//		if (product == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok(product);
//	}
//	
	@PostMapping
	public Category create(@RequestBody Category category) {
		return categoryService.create(category);
	}
	
	@PutMapping("/{id}")
	public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
		return categoryService.update(category);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		categoryService.delete(id);
	}
	
}
