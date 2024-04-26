package com.co.ecommerce.backend.user;

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
@RequestMapping("/user")
public class UserController {
    private final UserBusiness productBusiness; 

    @Autowired
    public UserController(UserBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @GetMapping
    public Mono<ResponseEntity<List<UserEntity>>> getUsers(){
        return Mono.just(ResponseEntity.ok(productBusiness.getUsers()));
    }

    @PostMapping("/")
    public ResponseEntity<Void> createUser(@RequestBody SaveUserDTO createDtoUser){
        productBusiness.create(createDtoUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserEntity>>  getByIdUser(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(productBusiness.getByIdUser(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateByIdUser(@PathVariable("id") UUID id,  @RequestBody SaveUserDTO createDtoUser){
        productBusiness.update(id, createDtoUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdUser(@PathVariable("id") UUID id){
        productBusiness.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
