package com.richard.inventorymanagement.stockmovement.repository;

import com.richard.inventorymanagement.stockmovement.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovement, UUID> {
}
