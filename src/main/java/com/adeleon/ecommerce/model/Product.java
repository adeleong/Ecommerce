package com.adeleon.ecommerce.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Category category;
    private boolean availability;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;


    public Product(){}
    public Product(long id,
                   String name,
                   String description,
                   Category category,
                   boolean availability,
                   LocalDateTime creationDate,
                   LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.availability = availability;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;

    }
}
