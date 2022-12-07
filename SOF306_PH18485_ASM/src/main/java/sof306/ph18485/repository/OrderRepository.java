package sof306.ph18485.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sof306.ph18485.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT od FROM Order od WHERE od.account.username=:username")
	List<Order> findByUsername(@Param("username") String username);
	
}
