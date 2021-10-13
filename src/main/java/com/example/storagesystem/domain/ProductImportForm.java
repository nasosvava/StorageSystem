package com.example.storagesystem.domain;
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
@Table(name = "productImportForm")
public class ProductImportForm implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "import_date")
    @NotNull
    private Date importDate;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "receipts")
    @NotNull
    private String receipts;

    @OneToMany(mappedBy="productImportForm")
    @NotNull
    private List<Product> products;
}
