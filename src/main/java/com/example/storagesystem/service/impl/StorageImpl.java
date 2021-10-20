package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.repository.ShelveRepository;
import com.example.storagesystem.repository.StorageRepository;
import com.example.storagesystem.service.ShelveService;
import com.example.storagesystem.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private ShelveRepository shelveRepository;

    @Autowired
    private ShelveService shelveService;

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
        List<Shelve> shelf = new ArrayList<>();
        for (ShelveDTO shelveDTO : storageDTO.getShelvesDTO()){
            shelveDTO.setStorage(storage.getId());
            Shelve shelve = new Shelve();
            shelveService.dtoToEntity(shelveDTO,shelve);
            System.out.println(shelve.getName());


            shelve.setStorage(storageRepository.getById(storage.getId()));

            shelveRepository.save(shelve);
            shelf.add(shelve);
            System.out.println(shelve.getId());

            storage.setShelves(shelf);
            storageRepository.save(storage);

            storage.getShelves();
        }
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
        List<ShelveDTO> shelveDTOS = new ArrayList<>();
        for (int i = 0; i <storage.getShelves().size() ; i++) {
            ShelveDTO shelveDTO = new ShelveDTO();
            shelveDTOS.add(this.shelveService.entityToDto(shelveDTO,storage.getShelves().get(i)));
        }
        storageDTO.setShelvesDTO(shelveDTOS);
        return storageDTO;
    }
}
