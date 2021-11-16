package com.example.storagesystem.service.impl;


import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.ProductForm;
import com.example.storagesystem.domain.Stock;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.dto.ProductFormDTO;
import com.example.storagesystem.dto.StockDTO;
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
import java.util.Date;
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
    public ProductForm saveProductForm(ProductFormDTO productFormDTO) {
        ProductForm productForm;
        List<Product> allProducts = productRepository.findAll();
        List <Stock> allStocks = stockRepository.findAll();
        if (productFormDTO.getId() != null) {
            productForm = productFormRepository.getById(productFormDTO.getId());
        } else {
            productForm = new ProductForm();
        }
        dtoToEntity(productFormDTO, productForm);
        productForm.setFormCategory(FormCategory.valueOf(productFormDTO.getFormCategory()));
        productForm.setReceipts(TransactionCategory.valueOf(productFormDTO.getReceipts()));
        productForm.setImportDate(new Date());
        productFormRepository.save(productForm);
        return productForm;
    }



    @Override
    public List<ProductFormDTO> findAllForms() {
        List<ProductFormDTO> allProductFormDTO = new ArrayList<>();
        List<ProductForm> allProductForm = productFormRepository.findAll();
        for (ProductForm productForm : allProductForm) {
            ProductFormDTO productFormDTO = new ProductFormDTO();
            allProductFormDTO.add(entityToDto(productFormDTO, productForm));
            productFormDTO.setFormCategory(productForm.getFormCategory().name());
            productFormDTO.setReceipts(productForm.getReceipts().name());
            List<StockDTO> stockDTOS = new ArrayList<>();
            for(Stock stock :productForm.getStock()){
                StockDTO stockDTO = new StockDTO();
                stockService.entityToDto(stockDTO,stock);
                stockDTO.setProduct(stock.getProduct().getId());
                stockDTO.setBarcode(stock.getProduct().getBarcode());
                Product product = productRepository.findById(stock.getProduct().getId()).orElse(null);
                stockDTO.setBarcode(product.getBarcode());
                stockDTO.setProductForm(stock.getProductForm().getId());
                stockDTOS.add(stockDTO);
            }
            productFormDTO.setStock(stockDTOS);
        }
        return allProductFormDTO;
    }

    @Override
    public ProductFormDTO findById(Long id) {
        ProductForm productForm = productFormRepository.findById(id).orElse(null);
        ProductFormDTO productFormDTO = new ProductFormDTO();
        entityToDto(productFormDTO, productForm);
        productFormDTO.setFormCategory(productForm.getFormCategory().name());
        productFormDTO.setReceipts(productForm.getReceipts().name());
        List<StockDTO> stockDTOS = new ArrayList<>();
        for(Stock stock :productForm.getStock()){
            StockDTO stockDTO = new StockDTO();
            stockService.entityToDto(stockDTO,stock);
            stockDTOS.add(stockDTO);
        }
        productFormDTO.setStock(stockDTOS);
        return productFormDTO;
    }
}
