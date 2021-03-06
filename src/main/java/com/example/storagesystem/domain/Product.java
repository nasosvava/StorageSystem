package com.example.storagesystem.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "products")
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
    private double maxQuantity;

    @ManyToOne
    @JoinColumn(name = "measurementUnit_id")
    @NotNull
    private MeasurementUnit measurementUnit;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="shelve_id", nullable=false)
    private Shelve shelve;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Stock> stock;



}
