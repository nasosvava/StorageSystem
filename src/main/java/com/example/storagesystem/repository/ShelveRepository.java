package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.repository.customrepository.CustomShelveRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve ,Long> {
}
