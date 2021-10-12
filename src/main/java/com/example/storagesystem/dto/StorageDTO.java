package com.example.storagesystem.dto;

import com.example.storagesystem.domain.Shelve;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StorageDTO {

    private Long id;

    private String storage_description;

    private Set<ShelveDTO> shelvesDTO = new HashSet<>();

}
