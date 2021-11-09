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
@CrossOrigin("http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){

        return new ResponseEntity<>(productService.findAllProducts(),OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.saveProduct(productDTO),OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long productId){
        return new ResponseEntity<>(productService.findById(productId),OK);
    }

    @DeleteMapping ("/deleteById/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("product deleted successfully",OK);
    }
}
