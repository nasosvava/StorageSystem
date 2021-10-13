package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.repository.StorageRepository;
import com.example.storagesystem.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StorageImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

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
        return  storage;
    }

    @Override
    public List<StorageDTO> findAllStorages() {
        List<StorageDTO> allStorageDto = new ArrayList<>();
        List<Storage> allStorage = storageRepository.findAll();
        for (int i = 0; i < allStorage.size(); i++) {
            StorageDTO storageDTO = new StorageDTO();
            allStorageDto.add(entityToDto(storageDTO,allStorage.get(i)));
        }
        return allStorageDto;
    }


    @Override
    public void deleteStorage(Long id) {
    storageRepository.deleteById(id);
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
        return storageDTO;
    }
}
