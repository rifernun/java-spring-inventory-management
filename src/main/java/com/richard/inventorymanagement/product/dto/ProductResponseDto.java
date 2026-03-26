package com.richard.inventorymanagement.product.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private UUID id;
    private String sku;
    private String name;
    private UUID categoryId;
    private Integer currentQuantity;
    private Integer minQuantity;
}
