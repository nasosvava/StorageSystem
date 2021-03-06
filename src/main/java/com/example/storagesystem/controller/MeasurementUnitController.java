package com.example.storagesystem.controller;


import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.dto.MeasurementUnitDTO;
import com.example.storagesystem.service.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/measurementUnit")
@CrossOrigin("http://localhost:4200")
public class MeasurementUnitController {

    @Autowired
    private MeasurementUnitService measurementUnitService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllMeasurementUnits(){
        return new ResponseEntity<>(measurementUnitService.findAllMeasurementUnits(),OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createMeasurementUnit(@RequestBody MeasurementUnitDTO measurementUnitDTO){
        return new ResponseEntity<>(measurementUnitService.saveMeasurementUnit(measurementUnitDTO),OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findMeasurementUnitById(@PathVariable("id") Long measurementUnitId){
        return new ResponseEntity<>(measurementUnitService.findById(measurementUnitId),OK);
    }

    @DeleteMapping ("/deleteById/{id}")
    public void deleteProductById(@PathVariable("id") Long measurementUnitId){
        measurementUnitService.deleteMeasurementUnit(measurementUnitId);
    }
}
