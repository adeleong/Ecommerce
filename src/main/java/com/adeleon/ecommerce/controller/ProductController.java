package com.adeleon.ecommerce.controller;

import com.adeleon.ecommerce.dto.ProductInDTO;
import com.adeleon.ecommerce.model.Product;
import com.adeleon.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ecommerce/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('PRODUCT_MANAGER', 'PRICE_MANAGER')")
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PRODUCT_MANAGER', 'PRICE_MANAGER')")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Optional<Product> productOptional = this.productService.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    @PreAuthorize("hasRole('PRODUCT_MANAGER')")
    public ResponseEntity<Product> createProduct(@RequestBody ProductInDTO productInDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.createProduct(productInDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_MANAGER')")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody ProductInDTO productInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.updateProduct(id, productInDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_MANAGER')")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){

        this.productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
