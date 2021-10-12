package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.repository.ShelveRepository;
import com.example.storagesystem.service.ShelveService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShelveServiceImpl implements ShelveService {

    @Autowired
    private  ShelveRepository shelveRepository;

    @Override
    public Shelve shelve(Shelve shelve) {
        shelveRepository.save(shelve);
        return shelve;
    }

    @Override
    public List<Shelve> findAllShelves() {
        return shelveRepository.findAll();
    }

    @Override
    public Shelve updateShelve(Shelve shelve) {
        shelveRepository.save(shelve);
        return shelve;
    }

    @Override
    public void deleteShelve(Long id) {
        shelveRepository.deleteById(id);
    }

    @Override
    public Long numberOfShelves() {
        return null;
    }
}
