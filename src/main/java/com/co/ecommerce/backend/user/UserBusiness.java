package com.co.ecommerce.backend.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserBusiness {
    private final UserRepo userRepo;

    @Autowired
    public UserBusiness(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> getUsers(){
        return userRepo.findAll();
    }

    public UserEntity getByIdUser(UUID id){
        return userRepo.findById(id).get();
    }

    public void create(SaveUserDTO saveUserDTO){
        
        UserEntity userEntity = new UserEntity(saveUserDTO.getEmail(), saveUserDTO.getPassword());
            
        userRepo.save(userEntity);
    }
    
    public void update(UUID id, SaveUserDTO saveUserDTO){
        Optional<UserEntity> userExist = userRepo.findById(id);
        if(userExist.isPresent()){
            UserEntity userSave = userExist.get();
            
            userRepo.save(userSave);
        }
    }
    public void delete(UUID id){
        userRepo.deleteById(id);
    }
}
