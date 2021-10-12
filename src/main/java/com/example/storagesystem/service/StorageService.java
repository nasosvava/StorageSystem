package com.example.storagesystem.service;

import com.example.storagesystem.domain.Storage;

import java.util.List;

public interface StorageService {

    Storage saveStorage(Storage storage);

    List<Storage> findAllStorages();

    Storage updateStorage(Storage storage);

    void deleteStorage(Long id);

    Long numberOfShelves();

}
