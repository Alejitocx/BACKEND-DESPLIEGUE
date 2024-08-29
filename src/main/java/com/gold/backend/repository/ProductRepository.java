package com.gold.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gold.backend.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findById(Integer id);
	
	

}
