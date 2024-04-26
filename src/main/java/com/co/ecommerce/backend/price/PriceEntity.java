package com.co.ecommerce.backend.price;

import java.util.UUID;

import com.co.ecommerce.backend.currency.CurrencyEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="price")
public class PriceEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private Long value;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="currency_id")
    private CurrencyEntity currencies;

    public PriceEntity(Long value, CurrencyEntity currencies) {
        this.value = value;
        this.currencies = currencies;
    }
}
