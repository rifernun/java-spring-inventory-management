package com.richard.inventorymanagement.sector.repository;

import com.richard.inventorymanagement.sector.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectorRepository extends JpaRepository<Sector, UUID> {
}
