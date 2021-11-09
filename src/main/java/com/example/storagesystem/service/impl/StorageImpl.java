package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.repository.ShelveRepository;
import com.example.storagesystem.repository.StorageRepository;
import com.example.storagesystem.service.ProductService;
import com.example.storagesystem.service.ShelveService;
import com.example.storagesystem.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private ShelveRepository shelveRepository;

    @Autowired
    private ShelveService shelveService;

    @Autowired
    private ProductService productService;

    @Override
    public Storage dtoToEntity(StorageDTO storageDTO, Storage storage) {
        if(storageDTO == null){return null;}

        if(storage == null){storage = new Storage();}

        BeanUtils.copyProperties(storageDTO, storage);

        return storage;
    }

    @Override
    public StorageDTO entityToDto(StorageDTO storageDTO, Storage storage) {
        if(storage == null){return null;}

        if(storageDTO == null){storageDTO = new StorageDTO();}

        BeanUtils.copyProperties(storage, storageDTO);

        return storageDTO;
    }

    @Override
    public Storage saveStorage(StorageDTO storageDTO) {
        Storage storage;
        if(storageDTO.getId()!=null){
            storage = storageRepository.getById(storageDTO.getId());
        }else{
            storage = new Storage();
        }
        dtoToEntity(storageDTO,storage);

        storageRepository.save(storage);
//        for (int i = 0; i < storageDTO.getNumberOfShelves(); i++) {
//                Shelve shelve=  new Shelve();
//                shelve.setStorage(storage);
//                shelve.setName("S"+storage.getId()+i);
//            shelveRepository.save(shelve);
//
//        }
        return  storage;
    }

    @Override
    public List<StorageDTO> findAllStorages() {
        List<StorageDTO> allStorageDto = new ArrayList<>();
        List<Storage> allStorage = storageRepository.findAll();
        for (Storage storage : allStorage) {
            StorageDTO storageDTO = new StorageDTO();
            storageDTO.setNumberOfShelves(storage.getShelves().size());
            allStorageDto.add(entityToDto(storageDTO,storage));
            for(Shelve shelve : storage.getShelves()){
                ShelveDTO shelveDTO = new ShelveDTO();
                storageDTO.getShelvesDTO().add(shelveService.entityToDto(shelveDTO,shelve));
                List<ProductDTO> productDTOS = new ArrayList<>();
                for(Product product : shelve.getProduct()){
                    ProductDTO productDTO =  new ProductDTO();
                    productService.entityToDto(productDTO,product);
                    productDTO.setMeasurementUnitDTO(product.getMeasurementUnit().getName());
                    productDTOS.add(productDTO);
                }
                shelveDTO.setProductDTO(productDTOS);
            }
        }
    return allStorageDto;
    }


    @Override
    public String deleteStorage(Long id) {
        Storage storage = storageRepository.findById(id).orElse(null);
        if(storage.getShelves().size()==0 || storage.getShelves().equals(null)){
        storageRepository.deleteById(id);
        return "Storage deleted successfully";
        }else {
            return "This storage has items.Cant be deleted";
        }
    }

    @Override
    public Long numberOfShelves() {
        return storageRepository.count();
    }

    @Override
    public StorageDTO findById(Long id) {
        Storage storage = storageRepository.findById(id).orElse(null);
        StorageDTO storageDTO = new StorageDTO();
        entityToDto(storageDTO,storage);
        List<ShelveDTO> shelveDTOS = new ArrayList<>();
        for (Shelve  shelve : storage.getShelves()) {
            ShelveDTO shelveDTO = new ShelveDTO();
            shelveDTOS.add(shelveService.entityToDto(shelveDTO,shelve));
            List<ProductDTO> productDTOS = new ArrayList<>();
            for(Product product : shelve.getProduct()){
                ProductDTO productDTO =  new ProductDTO();
                productService.entityToDto(productDTO,product);
                productDTO.setMeasurementUnitDTO(product.getMeasurementUnit().getName());
                productDTOS.add(productDTO);
            }
            shelveDTO.setProductDTO(productDTOS);
        }
        storageDTO.setShelvesDTO(shelveDTOS);

        return storageDTO;
    }

    @Override
    public HashMap<Long,String> findAllStorageNames() {
        HashMap<Long,String> allStorageDto = new HashMap<Long, String>();
        List<Storage> allStorage = storageRepository.findAll();
        for(Storage storage : allStorage){
            allStorageDto.put(storage.getId(),storage.getName());
        }
        return allStorageDto;
    }
}
