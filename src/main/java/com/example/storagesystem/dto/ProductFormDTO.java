package com.example.storagesystem.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductFormDTO {

    private Long id;

    private String formCategory;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date importDate;

    private String description;

    private String receipts;

    private boolean isCanceled;

    private double quantity;

    private List<StockDTO> stock;

}
