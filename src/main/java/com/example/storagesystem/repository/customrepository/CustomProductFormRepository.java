package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductFormDTO;

import java.util.Date;
import java.util.List;

public interface CustomProductFormRepository {

    ProductFormDTO getProductImportFormId(Long id);

    List<ProductFormDTO> getAll();

    ProductFormDTO getProductImportFormReceipts(String receipts);

    ProductFormDTO getProductImportFormDTOExportDate(Date importDate);
}
