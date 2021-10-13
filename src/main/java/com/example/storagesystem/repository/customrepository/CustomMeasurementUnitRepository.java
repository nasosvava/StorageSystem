package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.dto.MeasurementUnitDTO;

public interface CustomMeasurementUnitRepository {

    MeasurementUnitDTO getMeasurementUnitId(Long id);

    MeasurementUnitDTO getMeasurementUnitName(String name);
}
