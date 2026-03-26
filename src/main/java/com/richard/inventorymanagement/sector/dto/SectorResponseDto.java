package com.richard.inventorymanagement.sector.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectorResponseDto {
    private UUID id;
    private String name;
    private String description;
}
