package com.co.ecommerce.backend.company;

import java.util.List;

import com.co.ecommerce.backend.product.ProductEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveCompanyDTO {
    private Long nit;
    private String name;
    private String address;
    private String phone;
    private List<ProductEntity> products;
}
