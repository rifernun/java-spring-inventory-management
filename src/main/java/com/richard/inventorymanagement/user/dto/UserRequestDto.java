package com.richard.inventorymanagement.user.dto;

import com.richard.inventorymanagement.shared.domain.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
