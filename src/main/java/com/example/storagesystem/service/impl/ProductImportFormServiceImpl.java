package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.ProductImportForm;
import com.example.storagesystem.repository.ProductImportFormRepository;
import com.example.storagesystem.service.ProductImportFormService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductImportFormServiceImpl implements ProductImportFormService{

    @Autowired
    ProductImportFormRepository productImportFormRepository;

    @Override
    public ProductImportForm productImportForm(ProductImportForm productImportForm) {
        productImportFormRepository.save(productImportForm);
        return productImportForm;
    }

    @Override
    public List<ProductImportForm> findAllImportItems() {
        return productImportFormRepository.findAll();
    }
}
