package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.dto.ProductImportFormDTO;

import java.util.Date;
import java.util.List;

public interface CustomProductImportFormRepository {

    ProductImportFormDTO getProductImportFormId(Long id);

    List<ProductImportFormDTO> getAll();

    ProductImportFormDTO getProductImportFormReceipts(String receipts);

    ProductImportFormDTO getProductImportFormDTOExportDate(Date importDate);
}
