package com.example.storagesystem.dto;


import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShelveDTO {

    private Long id;

    private Set<StorageDTO> storagesDTO = new HashSet<>();

    private Set<ProductDTO> productDTO;
}
