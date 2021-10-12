package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductImportForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImportFormRepository extends JpaRepository<ProductImportForm,Long> {
}
