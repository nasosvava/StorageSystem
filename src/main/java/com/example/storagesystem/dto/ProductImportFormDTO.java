package com.example.storagesystem.dto;


import com.example.storagesystem.domain.Product;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductImportFormDTO {

    private Long id;

    private Date importDate;

    private String description;

    private String receipts;

    private List<ProductDTO> productsDTO;
}
