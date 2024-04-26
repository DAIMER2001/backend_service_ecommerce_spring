package com.co.ecommerce.backend.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.ecommerce.backend.customer.CustomerEntity;
import com.co.ecommerce.backend.customer.CustomerRepo;
import com.co.ecommerce.backend.product.ProductEntity;
import com.co.ecommerce.backend.product.ProductRepo;

@Component
public class OrderBusiness {
    
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public OrderBusiness(OrderRepo orderRepo, ProductRepo productRepo, CustomerRepo customerRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }


    public List<OrderEntity> getOrders(){
        return orderRepo.findAll();
    }

    public OrderEntity getByIdOrder(UUID id){
        return orderRepo.findById(id).get();
    }

    public void create(SaveOrderDTO saveOrderDTO){
        List<ProductEntity> listProducts = new ArrayList<ProductEntity>();
        CustomerEntity customer = customerRepo.findById(saveOrderDTO.getCustomer()).orElseThrow();

        for (UUID price : saveOrderDTO.getProducts()) {
            listProducts.add(productRepo.findById(price).get());
        }
        OrderEntity orderEntity = new OrderEntity(
            saveOrderDTO.getDate(),
            listProducts,
            customer
        );
        orderRepo.save(orderEntity);
    }

    public void delete(UUID id){
        orderRepo.deleteById(id);
    }
}
