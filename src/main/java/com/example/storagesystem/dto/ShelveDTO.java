package com.example.storagesystem.dto;

import com.example.storagesystem.domain.Product;
import com.example.storagesystem.domain.Storage;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
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
