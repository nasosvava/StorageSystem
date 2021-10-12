package com.example.storagesystem.service;

import com.example.storagesystem.domain.ProductExportForm;

import java.util.List;

public interface ProductExportFormService {

    ProductExportForm productExportForm(ProductExportForm productExportForm);

    List<ProductExportForm> findAllExportForms();


}
