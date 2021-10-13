package com.example.storagesystem.service;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.dto.MeasurementUnitDTO;
import com.example.storagesystem.dto.ProductExportFormDTO;

import java.util.List;

public interface ProductExportFormService {

    ProductExportForm dtoToEntity(ProductExportFormDTO productExportFormDTO, ProductExportForm productExportForm);

    ProductExportFormDTO entityToDto(ProductExportFormDTO productExportFormDTO, ProductExportForm productExportForm);

    ProductExportForm saveProductExportForm(ProductExportFormDTO productExportFormDTO);

    List<ProductExportFormDTO> findAllExportForms();

    ProductExportFormDTO findById(Long id);
}
