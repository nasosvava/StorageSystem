package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.repository.StorageRepository;
import com.example.storagesystem.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StorageImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public Storage saveStorage(Storage storage) {
        storageRepository.save(storage);
        return  storage;
    }

    @Override
    public List<Storage> findAllStorages() {
        return storageRepository.findAll();
    }

    @Override
    public Storage updateStorage(Storage storage) {
        storageRepository.save(storage);
        return  storage;
    }

    @Override
    public void deleteStorage(Long id) {
    storageRepository.deleteById(id);
    }

    @Override
    public Long numberOfShelves() {
        return storageRepository.count();
    }
}
