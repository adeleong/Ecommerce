package com.adeleon.ecommerce.repository;

import com.adeleon.ecommerce.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
