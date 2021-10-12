package com.example.storagesystem.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
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
    private Set<Storage> storages = new HashSet<>();

    @OneToMany(mappedBy="shelve")
    @NotNull
    private Set<Product> product;
}
