package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ItemImportForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemImportFormRepository extends JpaRepository<ItemImportForm,Long> {
}
