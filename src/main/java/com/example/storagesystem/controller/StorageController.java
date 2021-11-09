package com.example.storagesystem.controller;


import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.service.ShelveService;
import com.example.storagesystem.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/storage")
@CrossOrigin(origins = "http://localhost:4200")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private ShelveService shelveService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStorages(){
        return new ResponseEntity<>(storageService.findAllStorages(),OK);
    }



    @PostMapping("/save")
    public ResponseEntity<?> createStorage(@RequestBody StorageDTO storageDTO){
        System.out.println("hallo");
        return new ResponseEntity<>( storageService.saveStorage(storageDTO),OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findStorageById(@PathVariable("id") Long storageId){
        return new ResponseEntity<>(storageService.findById(storageId),OK);
    }

    @DeleteMapping ("/deleteById/{id}")
    public ResponseEntity<?> deleteStorageById(@PathVariable("id") Long storageId){
        storageService.deleteStorage(storageId);

        return new ResponseEntity<>("",OK);
    }

    @GetMapping("/getNames")
    public ResponseEntity<?> getAllStoragesNames(){
        return new ResponseEntity<>(storageService.findAllStorageNames(),OK);
    }
}
