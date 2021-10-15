package com.example.storagesystem.repository.impl;

import com.example.storagesystem.dto.ProductFormDTO;
import com.example.storagesystem.repository.customrepository.CustomProductFormRepository;

import java.util.Date;
import java.util.List;

public class ProductFormRepositoryImpl implements CustomProductFormRepository {
    @Override
    public ProductFormDTO getProductImportFormId(Long id) {
        return null;
    }

    @Override
    public List<ProductFormDTO> getAll() {
        return null;
    }

    @Override
    public ProductFormDTO getProductImportFormReceipts(String receipts) {
        return null;
    }

    @Override
    public ProductFormDTO getProductImportFormDTOExportDate(Date importDate) {
        return null;
    }
}
