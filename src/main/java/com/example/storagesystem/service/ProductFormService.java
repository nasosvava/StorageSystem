package com.example.storagesystem.service;

import com.example.storagesystem.domain.ProductForm;
import com.example.storagesystem.dto.ProductFormDTO;

import java.util.List;

public interface ProductFormService {

    ProductForm dtoToEntity(ProductFormDTO productFormDTO, ProductForm productForm);

    ProductFormDTO entityToDto(ProductFormDTO productFormDTO, ProductForm productForm);

    ProductForm saveProductForm(ProductFormDTO productFormDTO);

    List<ProductFormDTO> findAllForms();

    ProductFormDTO findById(Long id);
}
