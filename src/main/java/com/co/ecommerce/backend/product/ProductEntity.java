package com.co.ecommerce.backend.product;

import java.util.List;
import java.util.UUID;

import com.co.ecommerce.backend.category.CategoryEntity;
import com.co.ecommerce.backend.price.PriceEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String code;
    private String name;
    private String characteristic;
    private Integer quantity;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<PriceEntity> prices;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CategoryEntity> categories;
    public ProductEntity(String code, String name, String characteristic, Integer quantity, List<PriceEntity> prices,
            List<CategoryEntity> categories) {
        this.code = code;
        this.name = name;
        this.characteristic = characteristic;
        this.quantity = quantity;
        this.prices = prices;
        this.categories = categories;
    }
    
}
