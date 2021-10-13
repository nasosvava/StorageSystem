package com.example.storagesystem.repository.impl;

import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.repository.customrepository.CustomProductExportFormRepository;

import java.util.Date;
import java.util.List;

public class ProductExportFormRepositoryImpl implements CustomProductExportFormRepository {
    @Override
    public ProductExportFormDTO getProductExportFormId(Long id) {
        return null;
    }

    @Override
    public List<ProductExportFormDTO> getAllProductExportForms() {
        return null;
    }

    @Override
    public ProductExportFormDTO getProductExportFormDeliveries(String deliveries) {
        return null;
    }

    @Override
    public ProductExportFormDTO getProductExportFormDTOExportDate(Date exportDate) {
        return null;
    }
}
