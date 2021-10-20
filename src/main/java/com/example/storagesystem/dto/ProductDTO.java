package com.example.storagesystem.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String barcode;

    private String description;

    private String measurementUnitDTO;

    private Long shelveDTO;

    private Long storageDTO;

//    private Long productFormDTO;

    private double maxQuantity;


}
