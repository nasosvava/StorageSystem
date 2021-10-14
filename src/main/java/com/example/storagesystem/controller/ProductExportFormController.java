package com.example.storagesystem.controller;

import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.dto.ProductExportFormDTO;
import com.example.storagesystem.service.ProductExportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/productExportForm")
@CrossOrigin("http://localhost:8080")
public class ProductExportFormController {

    @Autowired
    private ProductExportFormService productExportFormService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProductExportForms(){
        List<ProductExportFormDTO> productExportForms= productExportFormService.findAllExportForms();
        return new ResponseEntity<>(productExportForms,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProductExportForm(@RequestBody ProductExportFormDTO productExportFormDTO){
        ProductExportForm productExportForm = productExportFormService.saveProductExportForm(productExportFormDTO);
        return new ResponseEntity<>(productExportForm,OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findProductExportFormById(@PathVariable("id") Long productExportFormId){
        return new ResponseEntity<>(productExportFormService.findById(productExportFormId),OK);
    }
}
