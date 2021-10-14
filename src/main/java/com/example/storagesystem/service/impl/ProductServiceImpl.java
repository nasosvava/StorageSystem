package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.repository.ProductRepository;
import com.example.storagesystem.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product dtoToEntity(ProductDTO productDTO, Product product) {
        if(productDTO == null){return null;}

        if (product == null){product = new Product();}

        BeanUtils.copyProperties(productDTO,product);

        return  product;
    }

    @Override
    public ProductDTO entityToDto(ProductDTO productDTO, Product product) {
        if(product == null){return null;}

        if (productDTO == null){productDTO = new ProductDTO();}

        BeanUtils.copyProperties(product,productDTO);

        return  productDTO;
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product;
        if(productDTO.getId() != null){
            product = productRepository.getById(productDTO.getId());
        }else {
            product = new Product();
        }
        dtoToEntity(productDTO,product);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> allProductDTO = new ArrayList<>();
        List<Product> allProducts = productRepository.findAll();
        for (int i = 0; i < allProducts.size(); i++) {
            ProductDTO productDTO = new ProductDTO();
            allProductDTO.add(entityToDto(productDTO,allProducts.get(i)));
        }
        return allProductDTO;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Long numberOfProducts() {
        return null;
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductDTO productDTO = new ProductDTO();
        entityToDto(productDTO,product);
        return productDTO;
    }
}
