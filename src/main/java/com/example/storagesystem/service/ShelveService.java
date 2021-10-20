package com.example.storagesystem.service;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.dto.ShelveDTO;

import java.util.List;

public interface ShelveService {

    Shelve dtoToEntity(ShelveDTO shelveDTO, Shelve shelve);

    ShelveDTO entityToDto(ShelveDTO shelveDTO, Shelve shelve);

    ShelveDTO saveShelve(ShelveDTO shelveDTO);

    List<ShelveDTO> findAllShelves();

    ShelveDTO findById(Long id);




}
