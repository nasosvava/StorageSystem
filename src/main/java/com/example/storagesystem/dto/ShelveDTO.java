package com.example.storagesystem.dto;


import com.example.storagesystem.domain.Storage;
import lombok.*;



import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShelveDTO {

    private Long id;

    private String name;

    private Long storage;

    private List<ProductDTO> productDTO;
}
