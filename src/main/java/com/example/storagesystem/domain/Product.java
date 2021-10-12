package com.example.storagesystem.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barcode")
    @NotNull
    private String barcode;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "quantity")
    @NotNull
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "measurementUnit_id")
    @NotNull
    private MeasurementUnit measurementUnit;

    @ManyToOne
    @JoinColumn(name="shelve_id", nullable=false)
    @NotNull
    private Shelve shelve;

    @ManyToOne
    @JoinColumn(name = "productExportForm_id" ,nullable=false)
    private ProductExportForm productExportForm;

    @ManyToOne
    @JoinColumn(name = "productImportForm_id" ,nullable=false)
    @NotNull
    private ProductImportForm productImportForm;
}
