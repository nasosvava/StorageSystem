package com.example.storagesystem.service.impl;


import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.ProductForm;
import com.example.storagesystem.domain.Stock;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.dto.ProductFormDTO;
import com.example.storagesystem.enumaration.FormCategory;
import com.example.storagesystem.enumaration.TransactionCategory;
import com.example.storagesystem.repository.ProductFormRepository;
import com.example.storagesystem.repository.ProductRepository;
import com.example.storagesystem.repository.StockRepository;
import com.example.storagesystem.service.ProductFormService;
import com.example.storagesystem.service.ProductService;
import com.example.storagesystem.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductFormServiceImpl implements ProductFormService {

    @Autowired
    ProductFormRepository productFormRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public ProductForm dtoToEntity(ProductFormDTO productFormDTO, ProductForm productForm) {
        if(productFormDTO == null){return null;}

        if(productForm == null){
            productForm = new ProductForm();}

        BeanUtils.copyProperties(productFormDTO, productForm);

        return productForm;
    }

    @Override
    public ProductFormDTO entityToDto(ProductFormDTO productFormDTO, ProductForm productForm) {
        if(productForm == null){return null;}

        if(productFormDTO == null){
            productFormDTO = new ProductFormDTO();}
        BeanUtils.copyProperties(productForm, productFormDTO);
        return productFormDTO;
    }

    @Override
    public ProductFormDTO saveProductForm(ProductFormDTO productFormDTO) {
        ProductForm productForm;
        List<Product> allProducts = productRepository.findAll();
        List <Stock> allStocks = stockRepository.findAll();



        if (productFormDTO.getId() != null) {
            productForm = productFormRepository.getById(productFormDTO.getId());
        } else {
            productForm = new ProductForm();
        }

        dtoToEntity(productFormDTO, productForm);


//        for (Product product : allProducts) {
//            for (int i = 0; i < productFormDTO.getProductsDTO().size(); i++) {
//                if(product.getId()==productFormDTO.getProductsDTO().get(i)){
//                    productForm.getProducts().add(product);
//                }
//            }
//        }

        productForm.setFormCategory(FormCategory.valueOf(productFormDTO.getFormCategory()));
        productForm.setReceipts(TransactionCategory.valueOf(productFormDTO.getReceipts()));
        productFormRepository.save(productForm);
        return null;
    }

    @Override
    public List<ProductFormDTO> findAllForms() {
        List<ProductFormDTO> allProductFormDTO = new ArrayList<>();
        List<ProductForm> allProductForm = productFormRepository.findAll();
        for (int i = 0; i < allProductForm.size(); i++) {
            ProductFormDTO productFormDTO = new ProductFormDTO();
            allProductFormDTO.add(entityToDto(productFormDTO, allProductForm.get(i)));
        }
        return allProductFormDTO;
    }

    @Override
    public ProductFormDTO findById(Long id) {
        ProductForm productForm = productFormRepository.findById(id).orElse(null);
        ProductFormDTO productFormDTO = new ProductFormDTO();
        entityToDto(productFormDTO, productForm);
        return productFormDTO;
    }
}
