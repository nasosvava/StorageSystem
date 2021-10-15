package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductDTO;

import java.util.List;

public interface CustomProductRepository {

    ProductDTO getProductId(Long id);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductBarcode(String barcode);

    List<ProductDTO> getProductShelve(Long id);

    ProductDTO getProductForm(Long id);

    ProductDTO getProductQuantity(Long id);
}
