package com.richard.inventorymanagement.stockmovement.entity;

import com.richard.inventorymanagement.product.entity.Product;
import com.richard.inventorymanagement.shared.domain.MovementType;
import com.richard.inventorymanagement.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stock_movements")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private MovementType type;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt = Instant.now();
}
