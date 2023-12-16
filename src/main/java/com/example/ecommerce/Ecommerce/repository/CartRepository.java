package com.example.ecommerce.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.Ecommerce.model.Cart;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long>{

	public List<Cart> findByUsername(String username);
	
	
	public void deleteByUsernameAndProductid(String username,Long productid);
}
