package com.example.storagesystem.service.impl;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.domain.Storage;
import com.example.storagesystem.dto.ProductDTO;
import com.example.storagesystem.dto.ShelveDTO;
import com.example.storagesystem.dto.StorageDTO;
import com.example.storagesystem.repository.ShelveRepository;
import com.example.storagesystem.service.ProductService;
import com.example.storagesystem.service.ShelveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShelveServiceImpl implements ShelveService {

    @Autowired
    private ShelveRepository shelveRepository;

    @Autowired
    private ProductService productService;

    @Override
    public ShelveDTO entityToDto(ShelveDTO shelveDTO, Shelve shelve) {
        if(shelve == null){return null;}

        if(shelveDTO == null){shelveDTO = new ShelveDTO();}

        BeanUtils.copyProperties(shelve, shelveDTO);

        return shelveDTO;
    }

    @Override
    public Shelve dtoToEntity(ShelveDTO shelveDTO, Shelve shelve) {
        if(shelveDTO == null){return null;}

        if(shelve == null){shelve = new Shelve();}

        BeanUtils.copyProperties(shelveDTO, shelve);

        return shelve;
    }

    @Override
    public ShelveDTO saveShelve(ShelveDTO shelveDTO) {
        Shelve shelve;
        if (shelveDTO.getId() != null){
            shelve = shelveRepository.getById(shelveDTO.getId());
        }else {
            shelve = new Shelve();
        }
        dtoToEntity(shelveDTO,shelve);
        shelveRepository.save(shelve);
        return  shelveDTO;


    }

    @Override
    public List<ShelveDTO> findAllShelves() {
        List<ShelveDTO> allShelveDto = new ArrayList<>();
        List<Shelve> allShelve = shelveRepository.findAll();
        for (Shelve shelve : allShelve) {
            ShelveDTO shelveDTO = new ShelveDTO();
            allShelveDto.add(entityToDto(shelveDTO,shelve));
            shelveDTO.setStorage(shelve.getStorage().getId());
            List<ProductDTO> productDTOS = new ArrayList<>();
            for(Product product : shelve.getProduct()){
                ProductDTO productDTO =  new ProductDTO();
                productService.entityToDto(productDTO,product);
                productDTO.setMeasurementUnitDTO(product.getMeasurementUnit().getName());
                productDTOS.add(productDTO);
            }
            shelveDTO.setProductDTO(productDTOS);
        }
        return allShelveDto;
    }

    @Override
    public ShelveDTO findById(Long id) {
        Shelve shelve = shelveRepository.findById(id).orElse(null);
        ShelveDTO shelveDTO = new ShelveDTO();
        entityToDto(shelveDTO,shelve);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product : shelve.getProduct()){
            ProductDTO productDTO =  new ProductDTO();
            productService.entityToDto(productDTO,product);
            productDTO.setMeasurementUnitDTO(product.getMeasurementUnit().getName());
            productDTOS.add(productDTO);
        }
        shelveDTO.setProductDTO(productDTOS);
        shelveDTO.setStorage(shelve.getStorage().getId());
        return shelveDTO;
    }

    @Override
    public String deleteShelveById(Long id) {
        Shelve shelve = shelveRepository.findById(id).orElse(null);
        if(shelve.getProduct().equals(null)){
            shelveRepository.deleteById(id);
            return "Shelve deleted successfully";
        }else{
            return "This shelve has products.Cant be deleted";
        }
    }

}
