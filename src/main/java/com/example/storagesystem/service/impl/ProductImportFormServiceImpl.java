package com.example.storagesystem.service.impl;


import com.example.storagesystem.domain.ProductImportForm;
import com.example.storagesystem.dto.ProductImportFormDTO;
import com.example.storagesystem.repository.ProductImportFormRepository;
import com.example.storagesystem.service.ProductImportFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductImportFormServiceImpl implements ProductImportFormService{

    @Autowired
    ProductImportFormRepository productImportFormRepository;


    @Override
    public ProductImportForm dtoToEntity(ProductImportFormDTO productImportFormDTO, ProductImportForm productImportForm) {
        if(productImportFormDTO == null){return null;}

        if(productImportForm == null){productImportForm = new ProductImportForm();}

        BeanUtils.copyProperties(productImportFormDTO, productImportForm);

        return productImportForm;
    }

    @Override
    public ProductImportFormDTO entityToDto(ProductImportFormDTO productImportFormDTO, ProductImportForm productImportForm) {
        if(productImportForm == null){return null;}

        if(productImportFormDTO == null){productImportFormDTO = new ProductImportFormDTO();}

        BeanUtils.copyProperties(productImportForm, productImportFormDTO);

        return productImportFormDTO;
    }

    @Override
    public ProductImportForm saveProductImportForm(ProductImportFormDTO productImportFormDTO) {
        ProductImportForm productImportForm;
        if(productImportFormDTO.getId() != null){
            productImportForm = productImportFormRepository.getById(productImportFormDTO.getId());
        }else {
            productImportForm = new ProductImportForm();
        }
        dtoToEntity(productImportFormDTO,productImportForm);
        return productImportForm;
    }

    @Override
    public List<ProductImportFormDTO> findAllImportForms() {
        List<ProductImportFormDTO> allProductImportFormDTO = new ArrayList<>();
        List<ProductImportForm> allProductImportForm = productImportFormRepository.findAll();
        for (int i = 0; i < allProductImportForm.size(); i++) {
            ProductImportFormDTO productImportFormDTO = new ProductImportFormDTO();
            allProductImportFormDTO.add(entityToDto(productImportFormDTO,allProductImportForm.get(i)));
        }
        return allProductImportFormDTO;
    }

    @Override
    public ProductImportFormDTO findById(Long id) {
        ProductImportForm productImportForm = productImportFormRepository.findById(id).orElse(null);
        ProductImportFormDTO productImportFormDTO = new ProductImportFormDTO();
        entityToDto(productImportFormDTO,productImportForm);
        return productImportFormDTO;
    }
}
