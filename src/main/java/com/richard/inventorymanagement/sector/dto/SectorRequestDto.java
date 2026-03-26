package com.richard.inventorymanagement.sector.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectorRequestDto {
    private String name;
    private String description;
}
