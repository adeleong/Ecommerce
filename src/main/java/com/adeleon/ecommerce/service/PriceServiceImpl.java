package com.adeleon.ecommerce.service;

import com.adeleon.ecommerce.dto.PriceInDTO;
import com.adeleon.ecommerce.mapper.PriceInDTOToPrice;
import com.adeleon.ecommerce.model.Price;
import com.adeleon.ecommerce.model.Product;
import com.adeleon.ecommerce.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final ProductService productService;
    private final PriceInDTOToPrice mapper;

    public PriceServiceImpl(PriceRepository priceRepository, ProductService productService, PriceInDTOToPrice mapper){
        this.priceRepository = priceRepository;
        this.productService = productService;
        this.mapper = mapper;
    }

    @Override
    public List<Price> findAll() {
        return this.priceRepository.findAll();
    }

    @Override
    public Optional<Price> findById(Long id) {
        return this.priceRepository.findById(id);
    }

    @Override
    @Transactional
    public Price createPrice(PriceInDTO priceInDTO) {
        Price price = mapper.map(priceInDTO);
        Optional<Product> product = this.productService.findById(price.getProduct().getId());
        price.setProduct(product.orElseThrow());
        return this.priceRepository.save(price);

    }

    @Override
    @Transactional
    public Price updatePrice(Long id, PriceInDTO priceInDTO) {
        Price price = mapper.map(priceInDTO);
        price.setId(id);
        price.setEndDate(LocalDateTime.now().plusDays(30L));
        return this.priceRepository.save(price);
    }

    @Override
    @Transactional
    public void deletePrice(Long id) {
        this.priceRepository.deleteById(id);
    }

}
