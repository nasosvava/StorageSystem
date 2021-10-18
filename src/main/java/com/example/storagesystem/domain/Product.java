package com.example.storagesystem.domain;


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
@Table(name = "products")
public class Product implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "measurementUnit_id")
    private MeasurementUnit measurementUnit;

    @ManyToOne
    @JoinColumn(name="shelve_id", nullable=false)
    private Shelve shelve;


    @ManyToMany(mappedBy = "products")
    private List<ProductForm> productForm =  new ArrayList<>();
}
