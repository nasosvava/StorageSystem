package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {

    Item findByBarcode(String barcode);
}
