package com.co.ecommerce.backend.price;

import com.co.ecommerce.backend.currency.CurrencyEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SavePriceDTO {

    private Long value;
    private CurrencyEntity currencies;
} 

