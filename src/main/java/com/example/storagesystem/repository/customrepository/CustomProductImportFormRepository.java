package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.dto.ProductImportFormDTO;

import java.util.Date;
import java.util.List;

public interface CustomProductImportFormRepository {

    ProductImportFormDTO findProductImportFormId(Long id);

    List<ProductImportFormDTO> findAll();

    ProductImportFormDTO findProductImportFormReceipts(String receipts);

    ProductImportFormDTO findProductImportFormDTOExportDate(Date importDate);
}
