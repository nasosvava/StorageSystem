package com.example.storagesystem.controller;

import com.example.storagesystem.domain.ProductForm;
import com.example.storagesystem.dto.ProductFormDTO;
import com.example.storagesystem.service.ProductFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/productForm")
@CrossOrigin("http://localhost:8080")
public class ProductFormController {

    @Autowired
    private ProductFormService productFormService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProductForms(){
        List<ProductFormDTO> productImportForms= productFormService.findAllForms();
        return new ResponseEntity<>(productImportForms,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProductForm(@RequestBody ProductFormDTO productFormDTO){
        ProductFormDTO productForm = productFormService.saveProductForm(productFormDTO);
        return new ResponseEntity<>(productForm,OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findProductFormById(@PathVariable("id") Long productForm){
        return new ResponseEntity<>(productFormService.findById(productForm),OK);
    }
}
