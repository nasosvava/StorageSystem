package com.example.storagesystem.controller;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.service.ShelveService;
import com.example.storagesystem.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/storage")
@CrossOrigin("http://localhost:8080")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private ShelveService shelveService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStorages(){
        return new ResponseEntity<>(storageService.findAllStorages(),OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStorage(@RequestBody StorageDTO storageDTO){
        return new ResponseEntity<>( storageService.saveStorage(storageDTO),OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findStorageById(@PathVariable("id") Long storageId){
        return new ResponseEntity<>(storageService.findById(storageId),OK);
    }
}
