package com.co.ecommerce.backend.price;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PriceBusiness {
    private final PriceRepo priceRepo;

    @Autowired
    public PriceBusiness(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    public List<PriceEntity> getPrices(){
        return priceRepo.findAll();
    }

    public PriceEntity getByIdPrice(UUID id){
        return priceRepo.findById(id).get();
    }

    public void create(SavePriceDTO savePriceDTO){
        PriceEntity priceEntity = new PriceEntity(savePriceDTO.getValue(), savePriceDTO.getCurrencies());
        priceRepo.save(priceEntity);
    }
    
    public void update(UUID id, SavePriceDTO savePriceDTO){
        Optional<PriceEntity> priceExist = priceRepo.findById(id);
        if(priceExist.isPresent()){
            PriceEntity priceSave = priceExist.get();
            priceSave.setValue(savePriceDTO.getValue());
            priceSave.setCurrencies(savePriceDTO.getCurrencies());
            priceRepo.save(priceSave);
        }
    }
    public void delete(UUID id){
        priceRepo.deleteById(id);
    }
}
