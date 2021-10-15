package com.example.storagesystem.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    private Long id;

    private String barcode;

    private String description;

    private double quantity;

    private Long measurementUnitDTO;

    private Long shelveDTO;

    private Long productFormDTO;
}
