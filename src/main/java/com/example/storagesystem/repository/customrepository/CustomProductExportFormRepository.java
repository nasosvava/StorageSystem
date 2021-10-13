package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductExportFormDTO;

import java.util.Date;
import java.util.List;

public interface CustomProductExportFormRepository {

    ProductExportFormDTO getProductExportFormId(Long id);

    List<ProductExportFormDTO> getAllProductExportForms();

    ProductExportFormDTO getProductExportFormDeliveries(String deliveries);

    ProductExportFormDTO getProductExportFormDTOExportDate(Date exportDate);
}
