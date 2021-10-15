package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFormRepository extends JpaRepository<ProductForm,Long> {
}
