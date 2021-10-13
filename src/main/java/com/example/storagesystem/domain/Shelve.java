package com.example.storagesystem.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "shelve")
public class Shelve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "shelves")
    @NotNull
    private List<Storage> storages = new ArrayList<>();

    @OneToMany(mappedBy="shelve")
    @NotNull
    private List<Product> product;
}
