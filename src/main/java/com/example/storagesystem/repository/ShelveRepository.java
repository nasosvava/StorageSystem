package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Shelve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelveRepository extends JpaRepository<Shelve,Long> {
}
