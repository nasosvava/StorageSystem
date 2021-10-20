package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.repository.MeasurementUnitRepository;
import com.example.storagesystem.repository.ProductRepository;
import com.example.storagesystem.repository.ShelveRepository;
import com.example.storagesystem.service.MeasurementUnitService;
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

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    private ShelveRepository shelveRepository;

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
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product;
        if(productDTO.getId() != null){
            product = productRepository.getById(productDTO.getId());
        }else {
            product = new Product();
        }
        dtoToEntity(productDTO,product);
        List<MeasurementUnit> measurementUnits= measurementUnitRepository.findAll();
       for(MeasurementUnit measurementUnit : measurementUnits){
           if (measurementUnit.getId() == productDTO.getMeasurementUnitDTO()){
               product.setMeasurementUnit(measurementUnit);
               break;
           }
       }
       List<Shelve> shelves = shelveRepository.findAll();
       for(Shelve shelve : shelves){
           if (shelve.getId()==productDTO.getShelveDTO()){
               product.setShelve(shelve);
               break;
           }
       }


        productRepository.save(product);
        return productDTO;
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
