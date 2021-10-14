package com.example.storagesystem.service;

import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.domain.ProductImportForm;
import com.example.storagesystem.dto.MeasurementUnitDTO;
import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.dto.ProductImportFormDTO;

import java.util.List;

public interface ProductImportFormService {

    ProductImportForm dtoToEntity(ProductImportFormDTO productImportFormDTO, ProductImportForm productImportForm);

    ProductImportFormDTO entityToDto(ProductImportFormDTO productImportFormDTO, ProductImportForm productImportForm);

    ProductImportForm saveProductImportForm(ProductImportFormDTO productImportFormDTO);

    List<ProductImportFormDTO> findAllImportForms();

    ProductImportFormDTO findById(Long id);
}
