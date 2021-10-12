package com.example.storagesystem.repository;


import com.example.storagesystem.domain.Product;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.repository.customrepository.CustomProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>, CustomProductRepository {


}
