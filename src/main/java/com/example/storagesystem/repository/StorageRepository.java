package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage,Long> {
}
