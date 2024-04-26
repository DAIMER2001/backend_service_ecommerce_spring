package com.co.ecommerce.backend.product;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductBusiness productBusiness; 

    @Autowired
    public ProductController(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<ProductEntity>>> getProducts(){
        return Mono.just(ResponseEntity.ok(productBusiness.getProducts()));
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProduct(@RequestBody SaveProductDTO createDtoProduct){
        productBusiness.create(createDtoProduct);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductEntity>>  getByIdProduct(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(productBusiness.getByIdProduct(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdProduct(@PathVariable("id") UUID id,  @RequestBody SaveProductDTO createDtoProduct){
        productBusiness.update(id, createDtoProduct);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdProduct(@PathVariable("id") UUID id){
        productBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    
    @GetMapping(path = "/report",produces = "application/pdf")
    public byte[] getReport() throws IOException {
        List<ProductEntity> listProducts =  productBusiness.getProducts();
        return Utils.createReport(listProducts).toByteArray();
    }
}
