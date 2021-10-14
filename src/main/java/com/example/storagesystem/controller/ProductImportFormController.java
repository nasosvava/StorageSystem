package com.example.storagesystem.controller;

import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.domain.ProductImportForm;
import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.dto.ProductImportFormDTO;
import com.example.storagesystem.service.ProductExportFormService;
import com.example.storagesystem.service.ProductImportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/productImportForm")
@CrossOrigin("http://localhost:8080")
public class ProductImportFormController {

    @Autowired
    private ProductImportFormService productImportFormService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProductImportForms(){
        List<ProductImportFormDTO> productImportForms= productImportFormService.findAllImportForms();
        return new ResponseEntity<>(productImportForms,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProductImportForm(@RequestBody ProductImportFormDTO productImportFormDTO){
        ProductImportForm productImportForm = productImportFormService.saveProductImportForm(productImportFormDTO);
        return new ResponseEntity<>(productImportForm,OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findProductExportFormById(@PathVariable("id") Long storageId){
        return new ResponseEntity<>(productImportFormService.findById(storageId),OK);
    }
}
