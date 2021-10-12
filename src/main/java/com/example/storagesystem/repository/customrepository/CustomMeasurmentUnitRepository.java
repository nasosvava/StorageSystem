package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.MeasurementUnitDTO;

public interface CustomMeasurmentUnitRepository {

    MeasurementUnitDTO findMeasurementUnitId(Long id);

    MeasurementUnitDTO findMeasurementUnitName(String name);
}
