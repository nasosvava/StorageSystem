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
public class ProductFormDTO {

    private Long id;

    private String formCategory;

    private Date importDate;

    private double quantity;

    private String description;

    private String transactionCategory;

    private boolean isCanceled;

    private List<ProductDTO> productsDTO;
}
