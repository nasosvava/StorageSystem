package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository<Stock,Long> {
}
