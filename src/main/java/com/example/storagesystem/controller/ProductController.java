package com.example.storagesystem.controller;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.domain.Product;
import com.example.storagesystem.dto.MeasurementUnitDTO;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin("http://localhost:8080")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){
        List<ProductDTO> productDTO = productService.findAllProducts();
        return new ResponseEntity<>(productDTO,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        Product product = productService.saveProduct(productDTO);
        return new ResponseEntity<>(product,OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long productId){
        return new ResponseEntity<>(productService.findById(productId),OK);
    }
}