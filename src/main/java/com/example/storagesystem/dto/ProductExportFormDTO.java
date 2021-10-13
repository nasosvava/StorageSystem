package com.example.storagesystem.dto;

import com.example.storagesystem.domain.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductExportFormDTO {

    private Long id;

    private Date exportDate;

    private String description;

    private String deliveries;

    private List<ProductDTO> productsDTO;
}
