package com.example.storagesystem.controller;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.service.ShelveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/shelve")
@CrossOrigin("http://localhost:8080")
public class ShelveController {

    @Autowired
    private ShelveService shelveService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllShelves(){
        List<ShelveDTO> shelves= shelveService.findAllShelves();
        return new ResponseEntity<>(shelves,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShelve(@RequestBody ShelveDTO shelveDTO){
        Shelve shelve = shelveService.saveShelve(shelveDTO);
        return new ResponseEntity<>(shelve,OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findShelveById(@PathVariable("id") Long storageId){
        return new ResponseEntity<>(shelveService.findById(storageId),OK);
    }
}
