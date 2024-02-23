package com.adeleon.ecommerce.service;

import com.adeleon.ecommerce.dto.ProductInDTO;
import com.adeleon.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product createProduct(ProductInDTO productInDTO);
    Product updateProduct(Long id, ProductInDTO productInDTO);
    void deleteProduct(Long id);

}
