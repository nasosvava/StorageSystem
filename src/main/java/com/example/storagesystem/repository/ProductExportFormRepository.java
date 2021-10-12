package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductExportForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductExportFormRepository extends JpaRepository<ProductExportForm,Long> {
}
