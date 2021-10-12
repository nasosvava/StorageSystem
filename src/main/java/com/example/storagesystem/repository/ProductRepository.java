package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
