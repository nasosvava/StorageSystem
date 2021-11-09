package com.example.storagesystem.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {

    private Long id;

    private Long product;

    private Long productForm;

    private double quantity;

    private String barcode;
}
