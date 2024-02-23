package com.adeleon.ecommerce.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
