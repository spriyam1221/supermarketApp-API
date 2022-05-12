package com.supermarketapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.supermarketapp.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByUserId(Integer userId);

	@Transactional
	@Modifying
	@Query("update orders o set o.status = :status where o.id=:id")
	void changestatus(@Param("id") Integer id, @Param("status") String status);

}
