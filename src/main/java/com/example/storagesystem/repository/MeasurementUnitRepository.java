package com.example.storagesystem.repository;

import com.example.storagesystem.domain.MeasurementUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit,Long>  {
}
