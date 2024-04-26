package com.co.ecommerce.backend.product;


import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveProductDTO {

    private String code;
    private String name;
    private String characteristic;
    private Integer quantity;
    private List<UUID> prices;
    private List<UUID> categories;
} 

