package com.example.storagesystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "measurementUnit_id")
    @NotNull
    private MeasurementUnit measurementUnit;

    @ManyToMany(mappedBy = "products")
    private List<Shelve> shelves = new ArrayList<>();;

    @ManyToMany(mappedBy = "products")
    private List<ProductForm> productForms = new ArrayList<>();
}
