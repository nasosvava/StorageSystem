package com.example.storagesystem.repository;

import com.example.storagesystem.domain.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit,Long> {
}
