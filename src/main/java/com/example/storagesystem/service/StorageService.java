package com.example.storagesystem.service;

import com.example.storagesystem.domain.Storage;

import java.util.List;

public interface StorageService {

    Storage saveStorage(Storage storage);

    List<Storage> storages();

    Storage updateStorage(Storage storage);

}
