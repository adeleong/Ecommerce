package com.adeleon.ecommerce.dto;

import com.adeleon.ecommerce.model.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceInDTO {

    private Product product;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private String currency;
    private BigDecimal tax;

}
