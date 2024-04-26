package com.co.ecommerce.backend.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.ecommerce.backend.category.CategoryEntity;
import com.co.ecommerce.backend.category.CategoryRepo;
import com.co.ecommerce.backend.price.PriceEntity;
import com.co.ecommerce.backend.price.PriceRepo;

import jakarta.transaction.Transactional;
@Component
public class ProductBusiness {
    private final ProductRepo productRepo;
    private final PriceRepo priceRepo;
    private final CategoryRepo categoryRepo;


    @Autowired
    public ProductBusiness(ProductRepo productRepo, PriceRepo priceRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.priceRepo = priceRepo;
        this.categoryRepo = categoryRepo;
    }

    @Transactional
    public List<ProductEntity> getProducts(){
        return productRepo.findAll();
    }

    @Transactional
    public ProductEntity getByIdProduct(UUID id){
        return productRepo.findById(id).get();
    }

    public void create(SaveProductDTO saveProductDTO){
        List<CategoryEntity> listCategories = new ArrayList<CategoryEntity>();
        List<PriceEntity> listPrices = new ArrayList<PriceEntity>();
        for (UUID price : saveProductDTO.getPrices()) {
            listPrices.add(priceRepo.findById(price).get());
        }
        
        for (UUID cateogry : saveProductDTO.getCategories()) {
            listCategories.add(categoryRepo.findById(cateogry).get());
        }

        ProductEntity productEntity = new ProductEntity(
        saveProductDTO.getCode(),
        saveProductDTO.getName(),
        saveProductDTO.getCharacteristic(),
        saveProductDTO.getQuantity(),
        listPrices,
        listCategories);
        productRepo.save(productEntity);
    }
    
    public void update(UUID id, SaveProductDTO saveProductDTO){
        Optional<ProductEntity> productExist = productRepo.findById(id);
        if(productExist.isPresent()){
            ProductEntity productSave = productExist.get();
            productSave.setCode(saveProductDTO.getCode());
            productSave.setName(saveProductDTO.getName());
            productSave.setCharacteristic(saveProductDTO.getCharacteristic());
            productSave.setQuantity(saveProductDTO.getQuantity());
            productRepo.save(productSave);
        }
    }
    public void delete(UUID id){
        productRepo.deleteById(id);
    }
}
