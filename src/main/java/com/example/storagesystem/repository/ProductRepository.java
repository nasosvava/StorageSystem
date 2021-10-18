package com.example.storagesystem.repository;


import com.example.storagesystem.domain.Product;
import com.example.storagesystem.repository.customrepository.CustomProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
