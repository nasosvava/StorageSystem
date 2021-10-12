package com.example.storagesystem.service;

import com.example.storagesystem.domain.Shelve;

import java.util.List;

public interface ShelveService {

    Shelve shelve(Shelve shelve);

    List<Shelve> findAllShelves();

    Shelve updateShelve(Shelve shelve);

    void deleteShelve(Long id);

    Long numberOfShelves();
}
