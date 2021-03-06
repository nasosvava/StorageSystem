package com.example.storagesystem.service;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.dto.MeasurementUnitDTO;

import java.util.List;

public interface MeasurementUnitService {

    MeasurementUnit dtoToEntity(MeasurementUnitDTO measurementUnitDTO, MeasurementUnit measurementUnit);

    MeasurementUnitDTO entityToDto(MeasurementUnitDTO measurementUnitDTO, MeasurementUnit measurementUnit);

    MeasurementUnitDTO saveMeasurementUnit(MeasurementUnitDTO measurementUnitDTO);

    List<MeasurementUnitDTO> findAllMeasurementUnits();

    void deleteMeasurementUnit(Long id);

    MeasurementUnitDTO findById(Long id);

}
