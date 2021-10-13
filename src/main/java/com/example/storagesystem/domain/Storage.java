package com.example.storagesystem.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "storage")
public class Storage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    @NotNull
    private String storage_description;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "storage_shelve",
            joinColumns = { @JoinColumn(name = "storage_id") },
            inverseJoinColumns = { @JoinColumn(name = "shelve_id") }
    )
    private List<Shelve> shelves = new ArrayList<>();



}
