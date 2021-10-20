package com.example.storagesystem.domain;
import com.example.storagesystem.enumaration.FormCategory;
import com.example.storagesystem.enumaration.TransactionCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "productForm")
public class ProductForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "form_category")
    private FormCategory formCategory;

    @Column(name = "import_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date importDate;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "receipts")
    private TransactionCategory receipts;

    @OneToMany(mappedBy = "productForm")
    @JsonBackReference
    private List<Stock> stock;
}
