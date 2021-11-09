package com.example.storagesystem.controller;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.service.ShelveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/shelve")
@CrossOrigin
public class ShelveController {

    @Autowired
    private ShelveService shelveService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllShelves(){
        return new ResponseEntity<>(shelveService.findAllShelves(),OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createShelve(@RequestBody ShelveDTO shelveDTO){
        return new ResponseEntity<>(shelveService.saveShelve(shelveDTO),OK);
    }

    @DeleteMapping ("/deleteById/{id}")
    public void deleteShelveById(@PathVariable("id") Long shelveId){
        shelveService.deleteShelveById(shelveId);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findShelveById(@PathVariable("id") Long shelveId){
        return new ResponseEntity<>(shelveService.findById(shelveId),OK);
    }
}
