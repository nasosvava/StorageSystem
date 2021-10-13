package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.repository.customrepository.CustomStorageRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage,Long> {
}
