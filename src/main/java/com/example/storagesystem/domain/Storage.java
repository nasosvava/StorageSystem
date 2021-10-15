package com.example.storagesystem.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "storage")
public class Storage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String storage_description;


    @OneToMany(mappedBy = "storage")
    @JsonIgnore
    private List<Shelve> shelves = new ArrayList<>();

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", storage_description='" + storage_description + '\'' +
                ", shelves=" + shelves +
                '}';
    }
}
