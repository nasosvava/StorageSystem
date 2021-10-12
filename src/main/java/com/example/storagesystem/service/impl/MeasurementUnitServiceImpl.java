package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.repository.MeasurementUnitRepository;
import com.example.storagesystem.service.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MeasurementUnitServiceImpl implements MeasurementUnitService {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Override
    public MeasurementUnit measurementUnit(MeasurementUnit measurementUnit) {
        measurementUnitRepository.save(measurementUnit);
        return measurementUnit;
    }

    @Override
    public List<MeasurementUnit> findAllMeasurementUnits() {
        return measurementUnitRepository.findAll();
    }

    @Override
    public MeasurementUnit updateMeasurementUnit(MeasurementUnit measurementUnit) {
        measurementUnitRepository.save(measurementUnit);
        return measurementUnit;
    }

    @Override
    public void deleteMeasurementUnit(Long id) {
    measurementUnitRepository.deleteById(id);
    }
}
