package com.example.storagesystem.repository.customrepository;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.dto.StorageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomStorageRepository {

    StorageDTO getStorageById(Long id);

    List<StorageDTO> getAllStorages();


}
