package com.example.storagesystem.domain;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "productExportForm")
public class ProductExportForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "export_date")
    private Date exportDate;

    @Column(name = "description")
    private String description;

    @Column(name = "deliveries")
    private String deliveries;

    @OneToMany(mappedBy= "productExportForm")
    private List<Product> products;
}
