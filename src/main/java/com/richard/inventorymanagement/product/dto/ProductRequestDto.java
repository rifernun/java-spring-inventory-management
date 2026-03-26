package com.richard.inventorymanagement.product.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {
    private String sku;
    private String name;
    private UUID categoryId;
    private Integer minQuantity;
}
