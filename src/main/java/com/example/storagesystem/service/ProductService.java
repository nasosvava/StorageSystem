package com.example.storagesystem.service;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    Product dtoToEntity(ProductDTO productDTO, Product product);

    ProductDTO entityToDto(ProductDTO productDTO,Product product);

    ProductDTO saveProduct(ProductDTO productDTO);

    List<ProductDTO> findAllProducts();

    void deleteProduct(Long id);

    Long numberOfProducts();

    ProductDTO findById(Long id);
}
