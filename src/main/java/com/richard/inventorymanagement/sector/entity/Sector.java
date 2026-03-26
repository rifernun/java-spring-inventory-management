package com.richard.inventorymanagement.sector.entity;

import com.richard.inventorymanagement.shared.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sectors")
public class Sector extends BaseEntity {

    @Column(name = "description")
    private String description;
}
