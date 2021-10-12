package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ProductDTO;

import java.util.List;

public interface CustomProductRepository {

    ProductDTO findProductId(Long id);

    List<ProductDTO> findAllProducts();

    ProductDTO findProductBarcode(String barcode);

    List<ProductDTO> findProductShelve(Long id);

    ProductDTO findProductExportForm(Long id);

    ProductDTO findProductImportForm(Long id);
}
