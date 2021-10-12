package com.example.storagesystem.service;

import com.example.storagesystem.domain.MeasurementUnit;

import java.util.List;

public interface MeasurementUnitService {

    MeasurementUnit measurementUnit(MeasurementUnit measurementUnit);

    List<MeasurementUnit> findAllMeasurementUnits();

    MeasurementUnit updateMeasurementUnit (MeasurementUnit measurementUnit);

    void deleteMeasurementUnit(Long id);
}
