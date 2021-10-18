package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.ProductForm;
import com.example.storagesystem.domain.Stock;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.dto.StockDTO;
import com.example.storagesystem.enumaration.FormCategory;
import com.example.storagesystem.repository.ProductFormRepository;
import com.example.storagesystem.repository.ProductRepository;
import com.example.storagesystem.repository.StockRepository;
import com.example.storagesystem.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFormRepository productFormRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock dtoToEntity(StockDTO stockDTO, Stock stock) {
        if(stockDTO == null){return null;}

        if (stock == null){stock = new Stock();}

        BeanUtils.copyProperties(stockDTO,stock);

        return  stock;
    }

    @Override
    public StockDTO entityToDto(StockDTO stockDTO, Stock stock) {
        if(stock == null){return null;}

        if (stockDTO == null){stockDTO = new StockDTO();}

        BeanUtils.copyProperties(stock,stockDTO);

        return  stockDTO;
    }

    @Override
    public Stock saveStock(StockDTO stockDTO) {
        Product product = productRepository.findById(stockDTO.getProduct()).orElse(null);
        ProductForm productForm = productFormRepository.findById(stockDTO.getProductForm()).orElse(null);
        Stock stock ;
        if(stockDTO.getId() != null){
            stock = stockRepository.getById(stockDTO.getId());
        }else {
            stock = new Stock();
        }
        if(productForm.getFormCategory().equals(FormCategory.IMPORT_FORMS)){product.setMaxQuantity(product.getMaxQuantity()+stockDTO.getQuantity());}
        else{product.setMaxQuantity(product.getMaxQuantity()-stockDTO.getQuantity());}

        dtoToEntity(stockDTO,stock);
        stockRepository.save(stock);
        return null;
    }

    @Override
    public List<StockDTO> findAllStock() {
        return null;
    }

    @Override
    public StockDTO findById(Long id) {
        return null;
    }
}
