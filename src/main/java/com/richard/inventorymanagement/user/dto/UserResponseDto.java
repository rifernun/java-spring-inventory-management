package com.richard.inventorymanagement.user.dto;

import com.richard.inventorymanagement.shared.domain.UserRole;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private UUID id;
    private String name;
    private String email;
    private UserRole role;
}
