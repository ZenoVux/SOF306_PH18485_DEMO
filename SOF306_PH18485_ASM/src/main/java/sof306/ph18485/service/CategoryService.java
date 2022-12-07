package sof306.ph18485.service;

import java.util.List;

import sof306.ph18485.entity.Category;

public interface CategoryService {

	List<Category> findAll();

	Category create(Category category);

	Category update(Category category);

	void delete(Integer id);
}
