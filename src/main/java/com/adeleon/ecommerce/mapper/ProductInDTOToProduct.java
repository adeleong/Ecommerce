package com.adeleon.ecommerce.mapper;

import com.adeleon.ecommerce.dto.ProductInDTO;
import com.adeleon.ecommerce.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductInDTOToProduct implements  IMapper<ProductInDTO, Product>{

    @Override
    public Product map( ProductInDTO in ) {
        Product product = new Product();
        product.setName(in.getName());
        product.setDescription(in.getDescription());
        product.setCategory(in.getCategory());
        product.setAvailability(in.isAvailability());
        product.setCreationDate(LocalDateTime.now());
        return product;
    }
}
