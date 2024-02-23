package com.adeleon.ecommerce.controller;

import com.adeleon.ecommerce.dto.PriceInDTO;
import com.adeleon.ecommerce.model.Price;
import com.adeleon.ecommerce.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ecommerce/api/v1/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('PRODUCT_MANAGER', 'PRICE_MANAGER')")
    public List<Price> findAll() {
        return this.priceService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('PRODUCT_MANAGER', 'PRICE_MANAGER')")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Optional<Price> priceOptional = this.priceService.findById(id);
        if(priceOptional.isPresent()){
            return ResponseEntity.ok(priceOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('PRODUCT_MANAGER', 'PRICE_MANAGER')")
    public ResponseEntity<Price> createPrice(@RequestBody PriceInDTO priceInDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.priceService.createPrice(priceInDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PRICE_MANAGER')")
    public ResponseEntity<Price> updatePrice(@PathVariable("id") Long id, @RequestBody PriceInDTO priceInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.priceService.updatePrice(id, priceInDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PRICE_MANAGER')")
    public ResponseEntity<?> deletePrice(@PathVariable("id") Long id){

        this.priceService.deletePrice(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
