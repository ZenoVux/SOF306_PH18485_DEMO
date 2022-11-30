package sof306.ph18485.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
