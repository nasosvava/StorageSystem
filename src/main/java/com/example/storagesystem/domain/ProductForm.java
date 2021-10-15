package com.example.storagesystem.domain;
import com.example.storagesystem.enumaration.FormCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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

    @Column(name = "import_date")
    @NotNull
    private Date importDate;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "receipts")
    @NotNull
    private String receipts;

    @OneToMany(mappedBy="productForm")
    @NotNull
    private List<Product> products;
}
