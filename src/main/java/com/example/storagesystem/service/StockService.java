package com.example.storagesystem.service;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Stock;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.dto.StockDTO;

import java.util.Date;
import java.util.List;

public interface StockService {

    Stock dtoToEntity(StockDTO stockDTO, Stock stock);

    StockDTO entityToDto(StockDTO stockDTO, Stock stock);

    Stock saveStock(StockDTO StockDTO);

    List<StockDTO> findAllStock();

    StockDTO findById(Long id);

    double getProductQuantityForSpecificDate (Long productId , Date date);


}
