package com.co.ecommerce.backend.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveCustomerDTO {
    private String name;
    private String typeDocument;
    private Long numberDocument;
}
