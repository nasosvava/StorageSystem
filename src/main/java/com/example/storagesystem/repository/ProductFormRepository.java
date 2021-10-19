package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProductFormRepository extends JpaRepository<ProductForm,Long> {

//    ProductForm findProductFormByImportDate(Date date);
}
