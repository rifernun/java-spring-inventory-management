package com.richard.inventorymanagement.stockmovement.dto;

import com.richard.inventorymanagement.shared.domain.MovementType;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockMovementResponseDto {
    private UUID id;
    private UUID productId;
    private UUID userId;
    private MovementType type;
    private Integer quantity;
    private Instant createdAt;
}
