package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.repository.customrepository.CustomProductExportFormRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExportFormRepository extends JpaRepository<ProductExportForm,Long>  {
}
