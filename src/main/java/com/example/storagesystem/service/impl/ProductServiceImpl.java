package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.repository.ProductRepository;
import com.example.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(final Product product){
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(final Product product){
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(final Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public Long numberOfProducts(){
        return productRepository.count();
    }

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}
