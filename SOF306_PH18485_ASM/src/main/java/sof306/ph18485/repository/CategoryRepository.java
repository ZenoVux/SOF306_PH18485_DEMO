package sof306.ph18485.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category findByCode(String code);

}
