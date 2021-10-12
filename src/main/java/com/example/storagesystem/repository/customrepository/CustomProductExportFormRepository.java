package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductExportFormDTO;

import java.util.List;

public interface CustomProductExportFormRepository {

    ProductExportFormDTO findProductExportFormId(Long id);

    List<ProductExportFormDTO> findAll();

    ProductExportFormDTO findProductExportFormDeliveries(String deliveries);


}
