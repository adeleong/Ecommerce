package com.adeleon.ecommerce.service;

import com.adeleon.ecommerce.dto.PriceInDTO;
import com.adeleon.ecommerce.model.Price;
import java.util.List;
import java.util.Optional;

public interface PriceService {
    List<Price> findAll();
    Optional<Price> findById(Long id);
    Price createPrice(PriceInDTO priceInDTO);
    Price updatePrice(Long id, PriceInDTO priceInDTO);
    void deletePrice(Long id);

}
