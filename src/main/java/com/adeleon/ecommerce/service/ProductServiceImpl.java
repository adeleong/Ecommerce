package com.adeleon.ecommerce.service;

import com.adeleon.ecommerce.dto.ProductInDTO;
import com.adeleon.ecommerce.mapper.ProductInDTOToProduct;
import com.adeleon.ecommerce.model.Product;
import com.adeleon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductInDTOToProduct mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductInDTOToProduct mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id){
        return this.productRepository.findById(id);
    }

    @Override
    public Product createProduct(ProductInDTO productInDTO){
        Product product = mapper.map(productInDTO);
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductInDTO productInDTO){
        Product product = mapper.map(productInDTO);
        product.setId(id);
        product.setLastUpdate(LocalDateTime.now());
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id){
        this.productRepository.deleteById(id);
    }
}
