package com.adeleon.ecommerce.mapper;

import com.adeleon.ecommerce.dto.PriceInDTO;
import com.adeleon.ecommerce.model.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PriceInDTOToPrice implements IMapper<PriceInDTO, Price>{
    @Override
    public Price map(PriceInDTO in) {

        Price price = new Price();
        price.setProduct(in.getProduct());
        price.setStartDate(LocalDateTime.now());
        price.setUnitPrice(in.getUnitPrice());
        price.setCurrency(in.getCurrency());
        price.setTax(in.getTax());
        price.setDiscount(in.getDiscount());

        return price;
    }
}
