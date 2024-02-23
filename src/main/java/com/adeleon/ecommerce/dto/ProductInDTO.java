package com.adeleon.ecommerce.dto;

import com.adeleon.ecommerce.model.Category;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductInDTO {

    private String name;
    private String description;
    private Category category;
    private boolean availability;

}
