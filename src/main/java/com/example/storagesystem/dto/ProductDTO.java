package com.example.storagesystem.dto;

import com.example.storagesystem.domain.MeasurementUnit;
import com.example.storagesystem.domain.ProductExportForm;
import com.example.storagesystem.domain.ProductImportForm;
import com.example.storagesystem.domain.Shelve;
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

    private MeasurementUnitDTO measurementUnitDTO;

    private ShelveDTO shelveDTO;

    private ProductExportFormDTO productExportFormDTO;

    private ProductImportFormDTO productImportFormDTO;
}
