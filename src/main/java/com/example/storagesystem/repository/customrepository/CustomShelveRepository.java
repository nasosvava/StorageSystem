package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ShelveDTO;

import java.util.List;

public interface CustomShelveRepository {

    ShelveDTO findShelveId(Long id);

    List<ShelveDTO> findAll();

    List<ShelveDTO> findShelveStorage(Long id);

}
