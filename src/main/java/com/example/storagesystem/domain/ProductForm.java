package com.example.storagesystem.domain;
import com.example.storagesystem.enumaration.FormCategory;
import com.example.storagesystem.enumaration.TransactionCategory;
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
public class ProductForm implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "form_type",nullable = false)
    private FormCategory formCategory;

    @Column(name = "quantity")
    @NotNull
    private double quantity;

    @Column(name = "import_date")
    @NotNull
    private Date importDate;

    @Column(name = "description")
    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_category", nullable = false)
    @NotNull
    private TransactionCategory transactionCategory;

    @Column(name = "cancelForm")
    @NotNull
    private boolean isCanceled;

    @ManyToMany
    @JoinTable(
            name = "productForm_product",
            joinColumns = {@JoinColumn(name = "productForm_id")},
            inverseJoinColumns = {@JoinColumn (name = "product_id")}
    )
    private List<Product> products = new ArrayList<>();
}

