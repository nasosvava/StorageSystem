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
        return new ResponseEntity<>(productFormService.findAllForms(),OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createProductForm(@RequestBody ProductFormDTO productFormDTO){
        return new ResponseEntity<>(productFormService.saveProductForm(productFormDTO),OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findProductFormById(@PathVariable("id") Long productForm){
        return new ResponseEntity<>(productFormService.findById(productForm),OK);
    }
}
