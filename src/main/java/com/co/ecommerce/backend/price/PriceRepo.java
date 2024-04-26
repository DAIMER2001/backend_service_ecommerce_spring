package com.co.ecommerce.backend.price;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<PriceEntity, UUID>  {
    
}
