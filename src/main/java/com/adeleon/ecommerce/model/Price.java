package com.adeleon.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private BigDecimal unitPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal discount;
    private String currency;
    private BigDecimal tax;
    private String notes;

}
