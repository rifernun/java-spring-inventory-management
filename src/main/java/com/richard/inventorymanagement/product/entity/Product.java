package com.richard.inventorymanagement.product.entity;

import com.richard.inventorymanagement.shared.domain.BaseEntity;
import com.richard.inventorymanagement.category.entity.Category;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "sku", unique = true, nullable = false)
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "current_quantity", nullable = false)
    private Integer currentQuantity = 0;

    @Column(name = "min_quantity", nullable = false)
    private Integer minQuantity = 0;
}
