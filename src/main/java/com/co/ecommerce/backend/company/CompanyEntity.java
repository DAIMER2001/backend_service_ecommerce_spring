package com.co.ecommerce.backend.company;

import java.util.List;
import java.util.UUID;

import com.co.ecommerce.backend.product.ProductEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private Long nit;
    private String name;
    private String address;
    private String phone;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private List<ProductEntity> products;

    public CompanyEntity(Long nit, String name, String address, String phone) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

}
