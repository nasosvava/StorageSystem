package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.ShelveDTO;

import java.util.List;

public interface CustomShelveRepository {

    ShelveDTO getShelveId(Long id);

    List<ShelveDTO> getAll();

    List<ShelveDTO> getShelveStorage(Long id);

}
