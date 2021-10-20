package com.example.storagesystem.service;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.StorageDTO;

import java.util.List;

public interface StorageService {

    Storage dtoToEntity(StorageDTO storageDTO,Storage storage);

    StorageDTO entityToDto(StorageDTO storageDTO,Storage storage);

    Storage saveStorage(StorageDTO storageDTO);

    List<StorageDTO> findAllStorages();

    void deleteStorage(Long id);

    Long numberOfShelves();

    StorageDTO findById(Long id);



}
