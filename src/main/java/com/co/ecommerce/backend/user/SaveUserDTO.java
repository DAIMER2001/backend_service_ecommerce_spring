package com.co.ecommerce.backend.user;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SaveUserDTO {
    private String email;
    private String password;
} 

