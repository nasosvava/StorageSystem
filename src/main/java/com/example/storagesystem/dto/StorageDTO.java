package com.example.storagesystem.dto;


import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StorageDTO {

    private Long id;

    private String storage_description;

    private List<ShelveDTO> shelvesDTO = new ArrayList<>();

}
