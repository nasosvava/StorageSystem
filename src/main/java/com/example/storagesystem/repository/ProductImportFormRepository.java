package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductImportForm;
import com.example.storagesystem.repository.customrepository.CustomProductImportFormRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImportFormRepository extends JpaRepository<ProductImportForm,Long> {
}
