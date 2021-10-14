package com.example.storagesystem.controller;


import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.dto.MeasurementUnitDTO;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.service.MeasurementUnitService;
import com.example.storagesystem.service.ShelveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/shelve")
@CrossOrigin("http://localhost:8080")
public class MeasurementUnitController {

    @Autowired
    private MeasurementUnitService measurementUnitService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllMeasurementUnits(){
        List<MeasurementUnitDTO> measurementUnits= measurementUnitService.findAllMeasurementUnits();
        return new ResponseEntity<>(measurementUnits,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMeasurementUnits(@RequestBody MeasurementUnitDTO measurementUnitDTO){
        MeasurementUnit measurementUnit = measurementUnitService.saveMeasurementUnit(measurementUnitDTO);
        return new ResponseEntity<>(measurementUnit,OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findMeasurementUnitsById(@PathVariable("id") Long storageId){
        return new ResponseEntity<>(measurementUnitService.findById(storageId),OK);
    }
}