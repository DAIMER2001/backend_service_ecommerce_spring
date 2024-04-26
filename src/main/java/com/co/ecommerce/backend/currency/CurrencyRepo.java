package com.co.ecommerce.backend.currency;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyEntity, UUID>  {
    
}
