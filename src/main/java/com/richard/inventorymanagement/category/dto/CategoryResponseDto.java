package com.richard.inventorymanagement.category.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDto {
    private UUID id;
    private String name;
    private UUID sectorId;
}
