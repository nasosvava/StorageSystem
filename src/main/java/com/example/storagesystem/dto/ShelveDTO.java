package com.example.storagesystem.dto;


import lombok.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShelveDTO {

    private Long id;

    private List<StorageDTO> storagesDTO = new ArrayList<>();

    private List<ProductDTO> productDTO;
}
