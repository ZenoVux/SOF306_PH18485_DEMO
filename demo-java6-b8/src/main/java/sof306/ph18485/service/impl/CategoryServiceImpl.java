package sof306.ph18485.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Category;
import sof306.ph18485.repository.CategoryRepository;
import sof306.ph18485.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category create(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public void delete(Integer id) {
		categoryRepo.deleteById(id);
	}

}
