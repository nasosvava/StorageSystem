package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.repository.ProductExportFormRepository;
import com.example.storagesystem.service.ProductExportFormService;
import com.example.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductExportFormServiceImpl implements ProductExportFormService {

    @Autowired
    private ProductExportFormRepository productExportFormRepository;

    @Override
    public ProductExportForm productExportForm(ProductExportForm productExportForm) {
        return productExportFormRepository.save(productExportForm);
    }

    @Override
    public List<ProductExportForm> findAllExportForms() {
        return productExportFormRepository.findAll();
    }
}
