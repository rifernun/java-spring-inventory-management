package com.richard.inventorymanagement.stockmovement.dto;

import com.richard.inventorymanagement.shared.domain.MovementType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockMovementRequestDto {
    private UUID productId;
    private UUID userId;
    private MovementType type;
    private Integer quantity;
}
