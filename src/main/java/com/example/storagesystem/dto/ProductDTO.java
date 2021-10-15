package com.example.storagesystem.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    private Long id;

    private String barcode;

    private String description;

    private MeasurementUnitDTO measurementUnitDTO;

    private List<ShelveDTO> shelveDTO = new ArrayList<>();

//    private List<ProductDTO> productFormDTO = new ArrayList<>();
}
