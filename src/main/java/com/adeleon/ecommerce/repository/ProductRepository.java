package com.adeleon.ecommerce.repository;

import com.adeleon.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {

}
