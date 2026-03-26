package com.richard.inventorymanagement.category.entity;

import com.richard.inventorymanagement.shared.domain.BaseEntity;
import com.richard.inventorymanagement.sector.entity.Sector;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;
}
