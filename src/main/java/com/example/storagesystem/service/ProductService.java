package com.example.storagesystem.service;

import com.example.storagesystem.domain.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> findAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(Long id);

    Long numberOfProducts();
}
