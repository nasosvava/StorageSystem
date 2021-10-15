package com.example.storagesystem.repository.impl;

import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.repository.customrepository.CustomProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements CustomProductRepository {
    @Override
    public ProductDTO getProductId(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public ProductDTO getProductBarcode(String barcode) {
        return null;
    }

    @Override
    public List<ProductDTO> getProductShelve(Long id) {
        return null;
    }

    @Override
    public ProductDTO getProductForm(Long id) {
        return null;
    }

    @Override
    public ProductDTO getProductQuantity(Long id) {
        return null;
    }
}
