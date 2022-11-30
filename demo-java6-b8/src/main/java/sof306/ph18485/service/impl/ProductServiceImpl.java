package sof306.ph18485.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sof306.ph18485.entity.Product;
import sof306.ph18485.repository.ProductRepository;
import sof306.ph18485.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public <S extends Product> S save(S entity) {
		return productRepo.save(entity);
	}

	public boolean existsById(Integer id) {
		return productRepo.existsById(id);
	}

	public void deleteById(Integer id) {
		productRepo.deleteById(id);
	}

	@Override
	public Product create(Product product) {
		return productRepo.save(product);
	}

	@Override
	public void delete(Integer id) {
		productRepo.deleteById(id);
	}
	
}
