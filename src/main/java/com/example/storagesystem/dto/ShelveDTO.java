package com.example.storagesystem.dto;


import com.example.storagesystem.domain.Storage;
import lombok.*;



import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShelveDTO {

    private Long id;

    private String name;

    private Long storage;

    private String storageName;

    private List<ProductDTO> productDTO;


}
