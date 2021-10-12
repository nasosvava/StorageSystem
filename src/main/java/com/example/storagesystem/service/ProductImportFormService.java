package com.example.storagesystem.service;

import com.example.storagesystem.domain.ProductImportForm;

import java.util.List;

public interface ProductImportFormService {

    ProductImportForm productImportForm(ProductImportForm productImportForm);

    List<ProductImportForm> findAllImportItems();

}
