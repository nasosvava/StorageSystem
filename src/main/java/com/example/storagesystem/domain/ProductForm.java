package com.example.storagesystem.domain;
import com.example.storagesystem.enumaration.FormCategory;
import com.example.storagesystem.enumaration.TransactionCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "productForm")
public class ProductForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "form_category")
    @NotNull
    private FormCategory formCategory;

    @Column(name = "import_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull
    private Date importDate;

    @Column(name = "description")
    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "receipts")
    @NotNull
    private TransactionCategory receipts;

    @OneToMany(mappedBy = "productForm")
    @JsonBackReference

    private List<Stock> stock;
}
