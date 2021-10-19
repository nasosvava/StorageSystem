package com.example.storagesystem.controller;

import com.example.storagesystem.dto.ProductFormDTO;
import com.example.storagesystem.dto.StockDTO;
import com.example.storagesystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/stock")
@CrossOrigin("http://localhost:8080")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/create")
    public ResponseEntity<?> createStockForm(@RequestBody StockDTO stockDTO){
        return new ResponseEntity<>(stockService.saveStock(stockDTO),OK);
    }

    @GetMapping("/findByDate")
    public ResponseEntity<?> findByDate(@RequestParam("id") Long productId,@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date ){
        return new ResponseEntity<>(stockService.getProductQuantityForSpecificDate(productId,date),OK);
    }
}
