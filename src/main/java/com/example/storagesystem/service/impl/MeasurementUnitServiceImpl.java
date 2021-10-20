package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.dto.MeasurementUnitDTO;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.repository.MeasurementUnitRepository;
import com.example.storagesystem.service.MeasurementUnitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementUnitServiceImpl implements MeasurementUnitService {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;


    @Override
    public MeasurementUnit dtoToEntity(MeasurementUnitDTO measurementUnitDTO, MeasurementUnit measurementUnit) {
        if(measurementUnitDTO == null){return null;}

        if(measurementUnit == null){measurementUnit = new MeasurementUnit();}

        BeanUtils.copyProperties(measurementUnitDTO, measurementUnit);

        return measurementUnit;
    }

    @Override
    public MeasurementUnitDTO entityToDto(MeasurementUnitDTO measurementUnitDTO, MeasurementUnit measurementUnit) {
        if(measurementUnit == null){return null;}

        if(measurementUnitDTO == null){measurementUnitDTO = new MeasurementUnitDTO();}

        BeanUtils.copyProperties(measurementUnit, measurementUnitDTO);

        return measurementUnitDTO;
    }

    @Override
    public MeasurementUnitDTO saveMeasurementUnit(MeasurementUnitDTO measurementUnitDTO) {
        MeasurementUnit measurementUnit;
        if(measurementUnitDTO.getId() != null){
            measurementUnit = measurementUnitRepository.getById(measurementUnitDTO.getId());
        }else{
            measurementUnit = new MeasurementUnit();
        }
        dtoToEntity(measurementUnitDTO,measurementUnit);
        measurementUnitRepository.save(measurementUnit);
        return measurementUnitDTO;
    }

    @Override
    public List<MeasurementUnitDTO> findAllMeasurementUnits() {
        List<MeasurementUnitDTO> allMeasurementUnitDTO = new ArrayList<>();
        List<MeasurementUnit> allMeasurementUnits = measurementUnitRepository.findAll();
        for (int i = 0; i <allMeasurementUnits.size() ; i++) {
            MeasurementUnitDTO measurementUnitDTO = new MeasurementUnitDTO();
            allMeasurementUnitDTO.add(entityToDto(measurementUnitDTO,allMeasurementUnits.get(i)));
        }
        return allMeasurementUnitDTO;
    }

    @Override
    public void deleteMeasurementUnit(Long id) {

    }

    @Override
    public MeasurementUnitDTO findById(Long id) {
        MeasurementUnit measurementUnit = measurementUnitRepository.findById(id).orElse(null);
        MeasurementUnitDTO measurementUnitDTO = new MeasurementUnitDTO();
        entityToDto(measurementUnitDTO,measurementUnit);
        return measurementUnitDTO;
    }
}
