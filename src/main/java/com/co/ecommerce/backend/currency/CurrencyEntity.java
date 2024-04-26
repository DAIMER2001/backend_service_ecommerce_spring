package com.co.ecommerce.backend.currency;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="currency")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String description;
    public CurrencyEntity(String description) {
        this.description = description;
    }
}
