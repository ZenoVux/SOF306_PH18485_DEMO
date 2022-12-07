package sof306.ph18485.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.category.code = :categoryCode")
	List<Product> findByCategoryCode(@Param("categoryCode") String categoryCode);

	@Query("SELECT p FROM Product p WHERE p.code = :code")
	Optional<Product> findByCode(@Param("code") String code);

}
