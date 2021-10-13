package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.repository.ProductExportFormRepository;
import com.example.storagesystem.service.ProductExportFormService;
import com.example.storagesystem.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductExportFormServiceImpl implements ProductExportFormService {

    @Autowired
    private ProductExportFormRepository productExportFormRepository;


    @Override
    public ProductExportForm dtoToEntity(ProductExportFormDTO productExportFormDTO, ProductExportForm productExportForm) {
        if(productExportFormDTO == null){return null;}

        if(productExportForm == null){productExportForm = new ProductExportForm();}

        BeanUtils.copyProperties(productExportFormDTO, productExportForm);

        return productExportForm;
    }

    @Override
    public ProductExportFormDTO entityToDto(ProductExportFormDTO productExportFormDTO, ProductExportForm productExportForm) {
        if(productExportForm == null){return null;}

        if(productExportFormDTO == null){productExportFormDTO = new ProductExportFormDTO();}

        BeanUtils.copyProperties(productExportForm, productExportFormDTO);

        return productExportFormDTO;
    }

    @Override
    public ProductExportForm saveProductExportForm(ProductExportFormDTO productExportFormDTO) {
        ProductExportForm productExportForm;
        if(productExportFormDTO != null){
            productExportForm = productExportFormRepository.getById(productExportFormDTO.getId());
        }else {
            productExportForm = new ProductExportForm();
        }
        dtoToEntity(productExportFormDTO,productExportForm);
        return productExportForm;
    }

    @Override
    public List<ProductExportFormDTO> findAllExportForms() {
        List<ProductExportFormDTO> allProductExportFormDTO = new ArrayList<>();
        List<ProductExportForm> allProductExportForms = productExportFormRepository.findAll();
        for (int i = 0; i < allProductExportForms.size(); i++) {
            ProductExportFormDTO productExportFormDTO = new ProductExportFormDTO();
            allProductExportFormDTO.add(entityToDto(productExportFormDTO,allProductExportForms.get(i)));
        }
        return allProductExportFormDTO;
    }

    @Override
    public ProductExportFormDTO findById(Long id) {
        ProductExportForm productExportForm = productExportFormRepository.findById(id).orElse(null);
        ProductExportFormDTO productExportFormDTO = new ProductExportFormDTO();
        entityToDto(productExportFormDTO,productExportForm);
        return productExportFormDTO;
    }
}
