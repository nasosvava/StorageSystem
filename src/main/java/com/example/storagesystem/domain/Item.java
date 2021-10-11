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
@Table(name = "item")
public class Item implements Serializable{


    @Id
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
    @JoinColumn(name = "itemExportForm_id" ,nullable=false)
    @NotNull
    private  ItemExportForm itemExportForm;

    @ManyToOne
    @JoinColumn(name = "itemImportForm_id" ,nullable=false)
    private  ItemImportForm itemImportForm;
}
