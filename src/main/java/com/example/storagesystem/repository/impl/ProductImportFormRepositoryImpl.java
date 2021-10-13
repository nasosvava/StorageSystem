package com.example.storagesystem.repository.impl;

import com.example.storagesystem.dto.ProductImportFormDTO;
import com.example.storagesystem.repository.customrepository.CustomProductImportFormRepository;

import java.util.Date;
import java.util.List;

public class ProductImportFormRepositoryImpl implements CustomProductImportFormRepository {
    @Override
    public ProductImportFormDTO getProductImportFormId(Long id) {
        return null;
    }

    @Override
    public List<ProductImportFormDTO> getAll() {
        return null;
    }

    @Override
    public ProductImportFormDTO getProductImportFormReceipts(String receipts) {
        return null;
    }

    @Override
    public ProductImportFormDTO getProductImportFormDTOExportDate(Date importDate) {
        return null;
    }
}
