package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.repository.ShelfRepository;
import com.example.storagesystem.service.ShelveService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShelveServiceImpl implements ShelveService {

    @Autowired
    private ShelfRepository shelfRepository;

    @Override
    public Shelve shelve(Shelve shelve) {
        shelfRepository.save(shelve);
        return shelve;
    }

    @Override
    public List<Shelve> findAllShelves() {
        return shelfRepository.findAll();
    }

    @Override
    public Shelve updateShelve(Shelve shelve) {
        shelfRepository.save(shelve);
        return shelve;
    }

    @Override
    public void deleteShelve(Long id) {
        shelfRepository.deleteById(id);
    }

    @Override
    public Long numberOfShelves() {
        return null;
    }
}
