package com.example.storagesystem.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "itemExportForm")
public class ItemExportForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "export_date")
    private Date exportDate;

    @Column(name = "description")
    private String description;

    @Column(name = "deliveries")
    private String deliveries;

    @OneToMany(mappedBy= "itemExportForm")
    private Set<Item> items;
}
